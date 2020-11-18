package com.patterns.creational.singleton;

public class Executor {

    public static void main(String... args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(ReflectionInstanceCreator.createMultipleInstanceOfPrivateConstructor());
        }
        System.out.println("##############################################");
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton.getInstance());
        }
        System.out.println("##############################################");
        for (int i = 0; i < 5; i++) {
         //   System.out.println(ReflectionInstanceCreator.createMultipleInstanceOfPrivateConstructor());
        }
    }

}
