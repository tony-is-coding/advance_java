package com.cnc.pattern;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor {

    public static ThreadPoolExecutor getExecutor() {
        return new ThreadPoolExecutor(20, 20, 60, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
