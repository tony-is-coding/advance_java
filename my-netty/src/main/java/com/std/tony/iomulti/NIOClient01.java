package com.std.tony.iomulti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NIOClient01 {
    static final AtomicInteger at = new AtomicInteger(1);

    static final AtomicInteger succeed = new AtomicInteger(0);
    static final AtomicInteger failure = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,
                8,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024));
        final int nThreads = 20;

        final CountDownLatch latch = new CountDownLatch(nThreads);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            pool.submit(() -> task(latch));
        }
        latch.await();
        System.out.printf("request completed !! \nsucceed:%d \nfailure: %d \ncost %d ms", succeed.get(), failure.get(), (int) (System.currentTimeMillis() - start));
    }

    public static void task(CountDownLatch latch) {
        try {
            //发送到8888端口
            final Socket socket = new Socket("127.0.0.1", 8001);
            for (int i = 0; i < 5000; i++) {
                //输出流
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.write("server端你好，我是client-" + at.getAndIncrement());
                    printWriter.flush();
                    InputStream inputStream = socket.getInputStream();
                    byte[] readB = new byte[1024];
                    int in = inputStream.read(readB);
                    System.out.println(new String(readB, 0, in));
//                    succeed.incrementAndGet();
                } catch (Exception e) {
//                    failure.incrementAndGet();
                }
            }
            socket.getOutputStream().close();
            socket.getInputStream().close();
            socket.close();
        } catch (IOException e) {
        } finally {
            latch.countDown();
        }
    }
}
