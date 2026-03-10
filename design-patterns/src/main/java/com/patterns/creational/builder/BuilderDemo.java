package com.patterns.creational.builder;

import lombok.Getter;
import lombok.ToString;

public class BuilderDemo {

    public String[] buildValues(boolean includeA, boolean includeB) {
        BuilderClass.Builder builder = BuilderClass.Builder.getInstance();
        if (includeA) {
            builder = builder.withA();
        }
        if (includeB) {
            builder = builder.withB();
        }
        BuilderClass builderClass = builder.build();
        return new String[]{builderClass.getA(), builderClass.getB()};
    }


    @Getter
    @ToString
    private static final class BuilderClass {

        private String a;
        private String b;

        private BuilderClass() {

        }

        public static final class Builder {

            private String a;
            private String b;

            private Builder() {

            }

            public static Builder getInstance() {
                return new Builder();
            }

            public Builder withA() {
                this.a = "a";
                return this;
            }

            public Builder withB() {
                this.b = "b";
                return this;
            }

            public BuilderClass build() {
                BuilderClass builderClass = new BuilderClass();
                builderClass.a = this.a;
                builderClass.b = this.b;
                return builderClass;
            }

        }

    }


}
