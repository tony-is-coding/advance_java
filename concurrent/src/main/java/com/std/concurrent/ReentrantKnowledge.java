package com.std.concurrent;

import sun.misc.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantKnowledge {
    private static int reentrantInteger = 0;
    private static ReentrantReadWriteLock rwLock;
    private static ReentrantReadWriteLock.WriteLock wLock;
    private static ReentrantReadWriteLock.ReadLock rLock;

    {
        rwLock = new ReentrantReadWriteLock();
        rLock = rwLock.readLock();
        wLock = rwLock.writeLock();
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
            System.out.printf("inReentrant[%s]: %d\n", Thread.currentThread().getName(), reentrantInteger);
            lock.lock();
            System.out.printf("inReentrant[%s]: %d\n", Thread.currentThread().getName(), reentrantInteger);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantInteger--;
            lock.unlock();
        }
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantKnowledge m = new ReentrantKnowledge();

        // 可重入非可重入锁测试
        new Thread(() -> {
            try {
                m.inReentrant();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(m::reentrant).start();

        Thread.sleep(2000);


    }
}
