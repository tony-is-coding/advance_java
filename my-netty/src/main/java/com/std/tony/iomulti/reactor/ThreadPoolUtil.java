package com.std.tony.iomulti.reactor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * com.std.tony.iomulti.reactor - ThreadPool
 *
 * @author tony-is-coding
 * @date 2022/5/22 22:56
 */
class ThreadPoolUtil {
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            4,
            8,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1024),
            r -> new Thread(r, "acceptor"));
    private ThreadPoolUtil(){}

    public static ThreadPoolExecutor getPool() {
        return pool;
    }

    public static ThreadPoolExecutor newPool(int nThreads, String name) {
        return new ThreadPoolExecutor(
                nThreads,
                nThreads,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024),
                r -> new Thread(r, name));
    }
}
