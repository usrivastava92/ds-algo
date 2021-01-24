package com.prep.multithreading;

public class Driver {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(10);
        int[] ints = {0};
        Thread producer1 = new Thread(() -> {
            while (true) {
                blockingQueue.add(ints[0]++);
            }
        }, "producer1");
        Thread producer2 = new Thread(() -> {
            while (true) {
                blockingQueue.add(ints[0]++);
            }
        }, "producer2");
        Thread consumer1 = new Thread(() -> {
            while (true) {
                blockingQueue.poll();
            }
        }, "consumer1");
        Thread consumer2 = new Thread(() -> {
            while (true) {
                blockingQueue.poll();
            }
        }, "consumer2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }


}
