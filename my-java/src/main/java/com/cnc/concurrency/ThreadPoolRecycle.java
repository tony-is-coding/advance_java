package com.cnc.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * com.cnc.concurrency - ThreadPoolRecycle
 *
 * @author tony-is-coding
 * @date 2022/4/7 17:19
 */
public class ThreadPoolRecycle {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        executor.submit(() -> {
            threadLocal.set("hello world");
            threadLocal.remove();
        });

        Thread.sleep(2000);
        executor.submit(() -> {
            System.out.println(threadLocal.get());
        });

        Thread.sleep(2000);
    }
}
