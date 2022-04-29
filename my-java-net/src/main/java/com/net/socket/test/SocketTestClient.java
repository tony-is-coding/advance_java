package com.net.socket.test;

import lombok.Getter;
import org.apache.log4j.net.SocketServer;

import java.net.Socket;

/**
 * com.net.socket.test - SocketTestClient
 *
 * @author tony-is-coding
 * @date 2022/4/1 18:23
 */
public class SocketTestClient {

    @Getter
    static class Inner {
        private String name;
        public Inner(String name) {
            this.name = name;
        }
    }
    public static void task(Inner i) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程:" + i.getName());
        });
        t.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Inner i1 = new Inner("11111111");
        Inner i2 = new Inner("22222222");
        task(i1);
        i1 = i2;
        System.out.println("主线程:" + i1.getName());
        Thread.sleep(1000);
    }
}
