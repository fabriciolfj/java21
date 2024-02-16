package com.github.fabriciolfj.countdownlatchsemaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        int NUM_PERMITS = 3;

        Semaphore semaphore = new Semaphore(NUM_PERMITS);

        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Thread " + Thread.currentThread().getName() + " accessing resource.");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }


        try {
            Thread.sleep(5000);
            semaphore.release(NUM_PERMITS); //resetando as permissoes
            System.out.println("Semaphore permits reset to initial count.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
