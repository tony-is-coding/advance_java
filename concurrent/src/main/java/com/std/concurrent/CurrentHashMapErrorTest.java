package com.std.concurrent;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class CurrentHashMapErrorTest {
    static final int MAP_SIZE = 20;
    static final int THREADS = 20;
    static final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    static {
        for (int i = 0; i < MAP_SIZE; i++) map.put(i, i);
    }

    public static <K, V> V computeIfAbsent(Map<K, V> map, K key, Function<K, V> mappingFunction) {
        V value = map.get(key);
        if (value != null) {
            return value;
        }
        return map.computeIfAbsent(key, mappingFunction);
    }

    static class TestThread extends Thread {
        public void run() {
            int i = 0;
            int result = 0;
            while (result < 1000000) {
                i = (i + 1) % MAP_SIZE;
                result += map.computeIfAbsent(i, (key) -> key + key);
            }
        }
    }




    public static void main(String[] v) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            TestThread t = new TestThread();
            threads.add(t);
            t.start();
        }
        threads.get(0).join();
    }
}
