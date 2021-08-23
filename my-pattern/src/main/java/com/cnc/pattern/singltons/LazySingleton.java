package com.cnc.pattern.singltons;

import com.cnc.pattern.MyThreadPoolExecutor;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public String getName() {
        return "hello world";
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
