package com.std.concurrent;

public class ClassLayoutKnowledge {
    private int age;
    private String name;

    public ClassLayoutKnowledge(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
//        ClassLayoutKnowledge layout = new ClassLayoutKnowledge(24, "tony");
//
//        System.out.println(ClassLayout.parseInstance(layout).toPrintable());
        int n = 32768;
        n |= n >>> 1; // 49152
        n |= n >>> 2; // 61440
        n |= n >>> 4; // 65280
        n |= n >>> 8; // 65535
        n |= n >>> 16; // 65535

    }
}
