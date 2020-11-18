package com.patterns.behavioural.chainofresponsibility;

public class Executor {

    public static void main(String[] args) {
        ChainHandler key3 = new ChainHandler(null) {
            @Override
            public void handle(int rs) {
                System.out.println("Sanctioned by key3");
            }
        };
        ChainHandler key2 = new ChainHandler(key3) {
            @Override
            public void handle(int rs) {
                if (rs > 1000) {
                    System.out.println("Key2 can't handle, delegating request to successor");
                    successor.handle(rs);
                } else {
                    System.out.println("Sanctioned by key2");
                }
            }
        };
        ChainHandler key1 = new ChainHandler(key2) {
            @Override
            public void handle(int rs) {
                if (rs > 500) {
                    System.out.println("Key1 can't handle, delegating request to successor");
                    successor.handle(rs);
                } else {
                    System.out.println("Sanctioned by key1");
                }
            }
        };

        key1.handle(2);
    }

}
