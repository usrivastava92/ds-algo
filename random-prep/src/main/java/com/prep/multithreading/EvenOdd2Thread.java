package com.prep.multithreading;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class EvenOdd2Thread {

    public static void main(String[] args) {
        String lock = "lock";
        int max = 20;

        BlockingDeque<Integer> integerBlockingDeque = new LinkedBlockingDeque<>();

        Thread evenThread = new EvenThread(lock, max);
        Thread oddThread = new OddThread(lock, max);

        evenThread.start();
        oddThread.start();

    }

}

@RequiredArgsConstructor
class EvenThread extends Thread {

    private final String lock;
    private int i = 0;
    private final int max;

    @Override
    public void run() {
        synchronized (lock) {
            while (i < max) {
                System.out.println(i);
                i += 2;
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

@RequiredArgsConstructor
class OddThread extends Thread {

    private int i = 1;
    private final String lock;
    private final int max;

    @Override
    public void run() {
        synchronized (lock) {
            while (i < max) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                i += 2;
                lock.notifyAll();
            }
        }
    }

}
