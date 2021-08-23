package com.cnc.pattern.singltons;

public class LazyInnerClassSingleton {

    private static class InstanceHolder {
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

    private LazyInnerClassSingleton() {
        System.out.println();
    }

    public static LazyInnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }


    public String getName() {
        return this.toString();
    }

    public static void main(String[] args) {
        int totalPage = 400;

        int currentBatch = 0;
        double currentProgress = 20;
        final double REPORT_BATCH = 5;
        final double PERCENT_PER_BATCH = 80 / (totalPage / REPORT_BATCH + 1);

        while (currentProgress < 100) {
            currentProgress += PERCENT_PER_BATCH;
            System.out.println("当前进度为: " + currentProgress);
        }

    }
}
