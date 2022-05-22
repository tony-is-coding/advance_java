package com.std.tony.iomulti;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

public class NioBasedReactor {
    private Selector subSelector = null;
    private final int port;

    private final ThreadPoolExecutor acceptPool = new ThreadPoolExecutor(
            2,
            4,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1024),
            r -> new Thread(r, "acceptor"));
    private final ThreadPoolExecutor readWritePool = new ThreadPoolExecutor(
            4,
            6,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1024),
            r -> new Thread(r, "read—write"));

    public NioBasedReactor(int port) throws IOException {
        this.port = port;
    }

    private void handleRead(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        try {
            int count = socketChannel.read(readBuff);
            String msg = new String(readBuff.array(), 0, count);
            System.out.printf("接受到客户端信息: [ %s ] \n", msg);
            readBuff.flip();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readBuff.clear();
        }
    }

    private void handleWrite(SelectionKey key) {
        ByteBuffer writeBuff = ByteBuffer.allocate(128);
        try {
            writeBuff.put("this is a response".getBytes());
            writeBuff.flip();
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(writeBuff);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeBuff.clear();
        }
    }

    private void handleAccept(SelectionKey key) {
        ServerSocketChannel ch = (ServerSocketChannel) key.channel();
        try {
            SocketChannel sc = ch.accept();
            sc.configureBlocking(false);
            System.out.printf("远程客户端[%s]连接上...\n", sc.getRemoteAddress());
            sc.register(subSelector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run(Selector selector) {
        System.out.println("开始线程轮询：" + Thread.currentThread().getName());
        for (; ; ) {
            try {
                int ready = selector.select(300);
                if (ready <= 0) continue;
                final Set<SelectionKey> selectionKeys = selector.selectedKeys();
                if (selectionKeys.isEmpty()) continue;
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    final SelectionKey sk = iterator.next();
                    iterator.remove();
                    if (sk.isAcceptable()) {
                        handleAccept(sk);
                    } else if (sk.isReadable()) {
                        handleRead(sk);
                    } else if (sk.isWritable()) {
                        handleWrite(sk);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void listen() throws InterruptedException, IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", port));
        Selector acceptSelector = Selector.open();
        ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
        subSelector = Selector.open();
        System.out.println("开始监听端口" + port + "...");
        new Thread(() -> run(subSelector)).start();
        Thread t = new Thread(() -> run(acceptSelector));
        t.start();
        t.join();
    }

    public static void main(String[] args) throws Exception {
        NioBasedReactor server = new NioBasedReactor(8001);
        server.listen();
    }
}
