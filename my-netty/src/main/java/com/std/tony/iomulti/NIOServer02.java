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

/**
 * @author liming zeng
 * @create 2021-02-19 19:14
 */
public class NIOServer02 {

    private static Selector acceptSelector = null;
    private static Selector readSelector = null;
    private static Selector writeSelector = null;

    private static ServerSocketChannel ssc = null;

    private static ThreadPoolExecutor pool = null;

    public static void main(String[] args) {
        pool = new ThreadPoolExecutor(2, 16, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "thread");
            }
        });

        try {
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8001));
            ssc.configureBlocking(false);
            initSelectors();

            while (true) {
                handlerSelector(acceptSelector);
                handlerSelector(readSelector);
                handlerSelector(writeSelector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initSelectors() {
        try {
            acceptSelector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
            readSelector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(readSelector, SelectionKey.OP_ACCEPT);
            writeSelector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(writeSelector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handlerSelector(Selector selector) {
        try {
            int nReady = selector.select();
            if (nReady <= 0) {
                return;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            if (keys.isEmpty()) {
                return;
            }
            Iterator<SelectionKey> it = keys.iterator();
            CountDownLatch latch = new CountDownLatch(keys.size());
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();

                if (key.isAcceptable()) {
                    // 创建新的连接，并且把连接注册到selector上，而且，
                    // 声明这个channel只对读操作感兴趣。
                    pool.submit(() -> handlerAccept(latch, selector));
                } else if (key.isReadable()) {
                    pool.submit(() -> handlerRead(key, latch));
                } else if (key.isWritable()) {
                    pool.submit(() -> handlerWrite(key, latch));
                }
            }
            latch.await();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void handlerAccept(CountDownLatch latch, Selector selector) {
        try {
            SocketChannel socketChannel = ssc.accept();
            socketChannel.configureBlocking(false);
            // 将连接交给readSelector处理read事件
            socketChannel.register(readSelector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    private static void handlerRead(SelectionKey key, CountDownLatch latch) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        try {
            int count = socketChannel.read(readBuff);
            String msg = new String(readBuff.array(), 0, count);
            System.out.printf("接受到客户端信息: [ %s ]", msg);
            readBuff.flip();
            // 将连接交给writeSelector处理write事件
            socketChannel.register(writeSelector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readBuff.clear();
            latch.countDown();
        }
    }

    private static void handlerWrite(SelectionKey key, CountDownLatch latch) {
        ByteBuffer writeBuff = ByteBuffer.allocate(128);
        try {
            writeBuff.put("response".getBytes());
            writeBuff.flip();
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(writeBuff);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeBuff.clear();
            latch.countDown();
        }
    }
}

