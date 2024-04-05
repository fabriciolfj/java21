package com.github.fabriciolfj.countdownlatchsemaphore;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            new Thread(() -> {
                System.out.println("task completed by thread " + Thread.currentThread().getId());
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("all tasks completed. Main thread proceeds.");
    }
}
