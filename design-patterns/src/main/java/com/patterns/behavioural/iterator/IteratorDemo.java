package com.patterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratorDemo {

    public static void main(String[] args) {
        IterClass iterClass = new IterClass();
        iterClass.add(1);
        iterClass.add(2);
        iterClass.add(3);
        for (Integer i : iterClass) {
            System.out.println(i);
        }
        iterClass.forEach(System.out::println);
    }

    private static final class IterClass implements Iterable<Integer> {

        private final List<Integer> ARR;

        public IterClass() {
            ARR = new ArrayList<>();
        }

        void add(int a) {
            ARR.add(a);
        }

        @Override
        public Iterator<Integer> iterator() {
            System.out.println("creating iterator.... ");
            return new Iterator<Integer>() {

                private final List<Integer> local = ARR;
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < ARR.size();
                }

                @Override
                public Integer next() {
                    Integer element = ARR.get(index);
                    index++;
                    return element;
                }
            };
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            for (int i : ARR) {
                action.accept(i);
            }
        }

        @Override
        public Spliterator<Integer> spliterator() {
            return null;
        }
    }

}
