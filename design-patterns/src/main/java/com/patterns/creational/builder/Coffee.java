package com.patterns.creational.builder;

public class Coffee {

    private String milk;
    private String sugar;
    private String coffee;

    public static class Builder {

        private String milk;
        private String sugar;
        private String coffee;

        public Builder() {
        }

        public Builder setMilk(String milk) {
            this.milk = milk;
            return this;
        }

        public Builder setSugar(String sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder setCoffee(String coffee) {
            this.coffee = coffee;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    private Coffee(Builder builder) {
        this.milk = builder.milk;
        this.coffee = builder.coffee;
        this.sugar = builder.sugar;
    }

    public String getMilk() {
        return milk;
    }

    public String getSugar() {
        return sugar;
    }

    public String getCoffee() {
        return coffee;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "milk='" + milk + '\'' +
                ", sugar='" + sugar + '\'' +
                ", coffee='" + coffee + '\'' +
                '}';
    }
}
