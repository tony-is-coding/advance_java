package com.cnc.pattern.singltons;

public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }


    public String getName() {
        return "hello world";
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println(HungrySingleton.getInstance());

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
