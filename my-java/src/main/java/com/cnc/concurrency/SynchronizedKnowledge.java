package com.cnc.concurrency;

public class SynchronizedKnowledge {
    private static int count = 0;


    public void synchronizedInstanceLockOne() {
        synchronized (this) {
            for (int j = 0; j < 20; j++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.printf("count1: %d\n", count);
            }
        }
    }

    public void synchronizedInstanceLockTwo() {
        synchronized (this) {

            for (int j = 0; j < 20; j++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.printf("count2: %d\n", count);
            }
        }
    }

    synchronized public void synchronizedMethodLock() {
        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.printf("%s: %d\n", Thread.currentThread().getName(), count);
        }
    }

    synchronized public static void synchronizedStaticMethodLock() {
        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.printf("%s: %d\n", Thread.currentThread().getName(), count);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedKnowledge m = new SynchronizedKnowledge();

        // synchronized 关键字 实例锁测试
//        new Thread(m::synchronizedInstanceLockOne).start();
//        new Thread(m::synchronizedInstanceLockTwo).start();


        // synchronized 实例方法锁测试
        Thread t1 = new Thread(m::synchronizedMethodLock);
        t1.setName("thread-one");
        t1.start();
        Thread t2 = new Thread(m::synchronizedMethodLock);
        t2.setName("thread-two");
        t2.start();
        // 次数不是同一个instance, 原则上是 t3 与 t1,t2 不形成竞争关系, 不会造成阻塞
        SynchronizedKnowledge m2 = new SynchronizedKnowledge();
        Thread t3 = new Thread(m2::synchronizedMethodLock);
        t3.setName("thread-Three");
        t3.start();

        // synchronized 静态方法锁测试, 相当于当前锁属于SynchronizedKnowledge.class
//        Thread t1 = new Thread(SynchronizedKnowledge::synchronizedStaticMethodLock);
//        t1.setName("thread-one");
//        t1.start();
//        Thread t2 = new Thread(SynchronizedKnowledge::synchronizedStaticMethodLock);
//        t2.setName("thread-two");
//        t2.start();


        Thread.sleep(2000);
    }

}
