package com.std.tony.iomulti;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

public class NIOServer01 {
    private static int BLOCK = 1024;
    private static Selector selector = null;

    private final ByteBuffer writeBuffer = ByteBuffer.allocate(BLOCK);
    private final ByteBuffer readBuffer = ByteBuffer.allocate(BLOCK);


    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 16, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "thread");
        }
    });

    public NIOServer01(int port) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress("127.0.0.1", port));
        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void handleRead(SelectionKey key, CountDownLatch latch) {
        System.out.println("触发读事件");
        SocketChannel client = (SocketChannel) key.channel();
        readBuffer.clear();
        try {
            int count = client.read(readBuffer);
            if (count > 0) {
                String ping = new String(readBuffer.array(), 0, count);
                System.out.println(ping);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    private void handleWrite(SelectionKey key, CountDownLatch latch) {
        System.out.println("触发写事件");
        SocketChannel client = (SocketChannel) key.channel();
        writeBuffer.clear();
        writeBuffer.put("pong".getBytes());
        writeBuffer.flip();
        try {
            client.write(writeBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }

    }

    private void handleAccept(SelectionKey key, CountDownLatch latch) {
        ServerSocketChannel ch = (ServerSocketChannel) key.channel();
        System.out.println("触发接受事件");
        try {
            SocketChannel client = ch.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    private void listen() throws IOException {
        while (true) {
            // 不断监听
            int ready = selector.select();
            if (ready < 0) {
                continue;
            }
            // 返回此选择器的已选择键集。
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            if (selectionKeys.isEmpty()) {
                continue;
            }
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            try {
                CountDownLatch latch = new CountDownLatch(selectionKeys.size());
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    iterator.remove();

                    if (sk.isAcceptable()) {
                        pool.submit(() -> handleAccept(sk, latch));
                    } else if (sk.isReadable()) {
                        pool.submit(() -> handleRead(sk, latch));
                    } else if (sk.isWritable()) {
                        pool.submit(() -> handleWrite(sk, latch));
                    }
                }
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer01 server = new NIOServer01(8001);
        server.listen();
    }
}
