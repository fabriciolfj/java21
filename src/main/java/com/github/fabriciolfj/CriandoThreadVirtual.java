package com.github.fabriciolfj;

public class CriandoThreadVirtual {

    public static void main(String[] args) throws InterruptedException {
        var virtualThread = Thread.startVirtualThread(() -> {
            System.out.println("ok");
        });

        Thread.sleep(1000);
        //virtualThread.start();
    }
}
