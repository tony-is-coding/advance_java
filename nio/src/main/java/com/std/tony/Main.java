package com.std.tony;

import sun.misc.Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static int count1 = 0;
    private static int reentrantInteger = 0;

    public void c1() {
        Integer a = 126;
        synchronized (a) {
            for (int j = 0; j < 20; j++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count1++;
                System.out.printf("count1: %d\n", count1);
            }
        }
    }

    public void c2() {
        Integer a = 126;
        synchronized (a) {

            for (int j = 0; j < 20; j++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count1++;
                System.out.printf("count2: %d\n", count1);
            }
        }
    }

    public void reentrant() {
        synchronized (this) {
            for (int j = 0; j < 20; j++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantInteger++;
                reentrantInteger++;
                synchronized (this) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantInteger--;
                }

                System.out.printf("reentrant: %d\n", reentrantInteger);
            }

        }
    }

    public void inReentrant() throws InterruptedException {
        Lock lock = new Lock();
        lock.lock();
        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantInteger++;
            reentrantInteger++;
            lock.lock();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantInteger--;
            lock.unlock();

            System.out.printf("reentrant: %d\n", reentrantInteger);
        }
        lock.unlock();


    }

    public static void main(String[] args) throws InterruptedException {

        Main m = new Main();

//        for (int i = 0; i < 1; i++) {
//            new Thread(m::c1).start();
//        }
//
//        for (int i = 0; i < 1; i++) {
//            new Thread(m::c2).start();
//        }


        new Thread(() -> {
            try {
                m.inReentrant();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(2000);
        System.out.println(reentrantInteger);

    }
}
