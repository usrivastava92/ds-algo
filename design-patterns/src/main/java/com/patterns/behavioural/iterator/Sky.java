package com.patterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sky implements Iterable<String> {

    private final List<String> list;

    public Sky() {
        this.list = new ArrayList<>();
    }

    public void addStar(String star) {
        list.add(star);
    }

    @Override
    public Iterator<String> iterator() {
        System.out.println("Initializing iterator");
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                System.out.println("has next");
                return index < list.size();
            }

            @Override
            public String next() {
                System.out.println("next");
                return list.get(index++);
            }
        };
    }

}
