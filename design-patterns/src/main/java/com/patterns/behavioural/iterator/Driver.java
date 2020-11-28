package com.patterns.behavioural.iterator;

public class Driver {

    public static void main(String[] args) {
        Sky sky = new Sky();
        sky.addStar("A");
        sky.addStar("B");
        sky.addStar("C");
        sky.addStar("D");

        for (String star : sky) {
            System.out.println(star);
        }

        for (String star : sky) {
            System.out.println(star);
        }
    }

}
