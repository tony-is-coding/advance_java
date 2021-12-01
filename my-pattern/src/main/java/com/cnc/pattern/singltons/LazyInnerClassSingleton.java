package com.cnc.pattern.singltons;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LazyInnerClassSingleton {

    private static class InstanceHolder {
        static {
            System.out.println("inner initialize");
        }

        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

    static {
        System.out.println("outer initialize");
    }

    private LazyInnerClassSingleton() {
        System.out.println();
    }

    public static String getName1() {
        return "hello world1";
    }

    public static LazyInnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }


    public String getName() {
        return this.toString();
    }

    public static void main(String[] args) {
        Map<String, String> computeMap = new HashMap<>();

        BiFunction<String, String, String> presentFunc = (k, n) -> {
            if (n.equals(k + "xxxxxx")) {
                return k + "ssssss";
            }
            return n;
        };
        Function<String, String> absentFunc = k -> k + "xxxxxx";
        computeMap.put("name1", "tony");
        System.out.println(computeMap);
        computeMap.computeIfAbsent("name", absentFunc);
        System.out.println(computeMap);
        computeMap.computeIfPresent("name", presentFunc);
        System.out.println(computeMap);
    }
}
