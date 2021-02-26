package com.patterns.creational.singleton;

import org.junit.Assert;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonDemo {

    public static void main(String[] args) {
        Assert.assertEquals(SingletonClass.getInstance(), SingletonClass.getInstance());
    }

    public static final class SingletonClass {

        private SingletonClass() {

        }

        private static SingletonClass instance;
        private static final Lock LOCK = new ReentrantLock();

        public static SingletonClass getInstance() {
            if (instance == null) {
                LOCK.lock();
                if (instance == null) {
                    instance = new SingletonClass();
                }
                LOCK.unlock();
            }
            return instance;
        }

    }

}
