package com.patterns.creational.factory;

import lombok.ToString;

public class FactoryDemo {

    public String getProductType(int i) {
        FactoryProduct product = Factory.getInstance(i);
        return product == null ? null : product.getClass().getSimpleName();
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
