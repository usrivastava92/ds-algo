package com.patterns.creational.factory;

import lombok.ToString;

public class FactoryDemo {

    public static void main(String[] args) {
        System.out.println(Factory.getInstance(1));
        System.out.println(Factory.getInstance(2));
        System.out.println(Factory.getInstance(3));
    }


    private static final class Factory {
        private Factory() {

        }

        public static FactoryProduct getInstance(int i) {
            switch (i) {
                case 1:
                    return new ObjectA();
                case 2:
                    return new ObjectB();
                default:
                    return null;
            }
        }

    }

    private interface FactoryProduct {

    }

    @ToString
    private static final class ObjectA implements FactoryProduct {

    }

    @ToString
    private static final class ObjectB implements FactoryProduct {

    }

}
