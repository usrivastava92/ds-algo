package com.patterns.creational.prototype;

import lombok.Getter;
import lombok.ToString;

public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoSubclass protoSubclass = new ProtoSubclass("subclass");
        PrototypeClass prototypeClass1 = new PrototypeClass("A", protoSubclass);
        System.out.println(prototypeClass1);
        System.out.println(prototypeClass1.clone());
    }

    @Getter
    @ToString
    private static final class PrototypeClass implements Cloneable {
        private final String name;
        private final ProtoSubclass protoSubclass;

        public PrototypeClass(String name, ProtoSubclass protoSubclass) {
            this.name = name;
            this.protoSubclass = protoSubclass;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

    }

    @Getter
    private static final class ProtoSubclass implements Cloneable {
        private final String name;

        public ProtoSubclass(String name) {
            this.name = name;
        }
    }

}
