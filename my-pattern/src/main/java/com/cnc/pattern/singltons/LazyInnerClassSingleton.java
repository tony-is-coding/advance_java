package com.cnc.pattern.singltons;

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
        System.out.println(LazyInnerClassSingleton.getName1());
    }
}
