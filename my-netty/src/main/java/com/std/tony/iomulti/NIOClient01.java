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

    public static void main(String[] args) {
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,
                8,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024));
        final int times = 100000;

        final CountDownLatch latch = new CountDownLatch(times);
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            pool.submit(() -> task(latch));
        }
        System.out.printf("request [%d] times cost [%d] ms", times, (int) (System.currentTimeMillis() - start));
    }

    public static void task(CountDownLatch latch) {
        try {
            //发送到8888端口
            Socket socket = new Socket("127.0.0.1", 8001);
            //输出流
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("server端你好，我是client-" + at.getAndIncrement());
            printWriter.flush();
            InputStream inputStream = socket.getInputStream();
            byte[] readB = new byte[1024];
            int i = inputStream.read(readB);
            System.out.println(new String(readB, 0, i));
            //关闭资源
            printWriter.close();
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
