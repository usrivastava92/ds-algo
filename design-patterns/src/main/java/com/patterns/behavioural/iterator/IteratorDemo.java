package com.patterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratorDemo {

    public List<Integer> iterate(List<Integer> values) {
        IterClass iterClass = new IterClass();
        for (int value : values) {
            iterClass.add(value);
        }
        List<Integer> traversed = new LinkedList<>();
        for (Integer i : iterClass) {
            traversed.add(i);
        }
        return traversed;
    }

    public List<Integer> forEachElements(List<Integer> values) {
        IterClass iterClass = new IterClass();
        for (int value : values) {
            iterClass.add(value);
        }
        List<Integer> traversed = new LinkedList<>();
        iterClass.forEach(traversed::add);
        return traversed;
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
            return new Iterator<Integer>() {

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
