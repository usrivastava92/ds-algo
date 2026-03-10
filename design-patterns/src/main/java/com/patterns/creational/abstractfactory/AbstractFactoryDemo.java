package com.patterns.creational.abstractfactory;

import lombok.ToString;

public class AbstractFactoryDemo {

    public String getProductType(int factoryType, int productType) {
        Factory<FactoryProduct> factory = AbstractFactory.getInstance(factoryType);
        if (factory == null) {
            return null;
        }
        FactoryProduct product = factory.getInstance(productType);
        return product == null ? null : product.getClass().getSimpleName();
    }

    private static final class AbstractFactory {

        private AbstractFactory() {

        }

        public static Factory<FactoryProduct> getInstance(int i) {
            switch (i) {
                case 1:
                    return new FactoryA();
                case 2:
                    return new FactoryB();
                default:
                    return null;
            }
        }
    }

    private interface Factory<T> {
        T getInstance(int i);
    }

    private interface FactoryProduct {

    }

    private static final class FactoryA implements Factory<FactoryProduct> {

        private FactoryA() {

        }

        public FactoryProduct getInstance(int i) {
            switch (i) {
                case 1:
                    return new AbstractFactoryDemo.ObjectC();
                case 2:
                    return new AbstractFactoryDemo.ObjectD();
                default:
                    return null;
            }
        }
    }

    private static final class FactoryB implements Factory<FactoryProduct> {
        private FactoryB() {

        }

        public FactoryProduct getInstance(int i) {
            switch (i) {
                case 1:
                    return new AbstractFactoryDemo.ObjectA();
                case 2:
                    return new AbstractFactoryDemo.ObjectB();
                default:
                    return null;
            }
        }
    }

    @ToString
    private static final class ObjectA implements FactoryProduct {

    }

    @ToString
    private static final class ObjectB implements FactoryProduct {

    }

    @ToString
    private static final class ObjectC implements FactoryProduct {

    }

    @ToString
    private static final class ObjectD implements FactoryProduct {

    }

}
