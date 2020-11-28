package com.patterns.creational.builder;

public class Executor {

    public static void main(String[] args) {
        Coffee coffee = new Coffee.Builder().setCoffee("Bean").setMilk("Powder").setSugar("Cube").build();
        System.out.println(coffee);
    }

}
