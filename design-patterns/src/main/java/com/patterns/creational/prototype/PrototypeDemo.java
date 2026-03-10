package com.patterns.creational.prototype;

import lombok.Getter;
import lombok.ToString;

public class PrototypeDemo {

    public boolean isDistinctClone(String name, String subclassName) throws CloneNotSupportedException {
        ProtoSubclass protoSubclass = new ProtoSubclass(subclassName);
        PrototypeClass prototypeClass1 = new PrototypeClass(name, protoSubclass);
        return prototypeClass1 != prototypeClass1.clone();
    }

    public boolean sharesNestedReference(String name, String subclassName) throws CloneNotSupportedException {
        ProtoSubclass protoSubclass = new ProtoSubclass(subclassName);
        PrototypeClass prototypeClass1 = new PrototypeClass(name, protoSubclass);
        return prototypeClass1.getProtoSubclass() == prototypeClass1.clone().getProtoSubclass();
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
        protected PrototypeClass clone() throws CloneNotSupportedException {
            return (PrototypeClass) super.clone();
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
