package com.prep.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private final Queue<T> queue;
    private final int maxSize;
    private final ReentrantLock reentrantLock;
    private final Condition notEmpty;
    private final Condition notFull;

    public BlockingQueue(int maxSize) {
        reentrantLock = new ReentrantLock(true);
        queue = new ArrayDeque<>();
        notEmpty = reentrantLock.newCondition();
        notFull = reentrantLock.newCondition();
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public synchronized int size() {
        return queue.size();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public void add(T element) {
        try {
            reentrantLock.lock();
            while (queue.size() == maxSize) {
                System.out.println("blocking : " + Thread.currentThread().getName());
                await(notFull);
            }
            sleep(500);
            System.out.println("added : " + element + " by " + Thread.currentThread().getName());
            queue.add(element);
            notEmpty.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public T poll() {
        try {
            reentrantLock.lock();
            while (queue.isEmpty()) {
                System.out.println("blocking : " + Thread.currentThread().getName());
                await(notEmpty);
            }
            sleep(1500);
            T poll = queue.poll();
            System.out.println("polled : " + poll + " by " + Thread.currentThread().getName());
            notFull.signalAll();
            return poll;
        } finally {
            reentrantLock.unlock();
        }
    }

    private void await(Condition condition) {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
