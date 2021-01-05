package com.leet.ds.misc;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIntegerIterator {

    public static void main(String[] args) {
        List<NestedInteger> lista = new ArrayList<>();
        lista.add(new NestedIntegerImpl(6));
        List<NestedInteger> listb = new ArrayList<>();
        listb.add(new NestedIntegerImpl(4));
        listb.add(new NestedIntegerImpl(lista));
        List<NestedInteger> listc = new ArrayList<>();
        listc.add(new NestedIntegerImpl(1));
        listc.add(new NestedIntegerImpl(listb));
        NestedIterator nestedIterator = new NestedIterator(listc);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
        List<int[]> ans = new ArrayList<>();

    }

}

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

@ToString
class NestedIntegerImpl implements NestedInteger {

    private Integer integer;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

class NestedIterator implements Iterator<Integer> {

    private final List<NestedInteger> nestedList;
    private NestedIterator nestedIterator;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.index = 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        if (nestedList.get(index).isInteger()) {
            Integer val = nestedList.get(index).getInteger();
            index++;
            return val;
        }
        return nestedIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (nestedList == null || nestedList.isEmpty() || index >= nestedList.size()) {
            return false;
        }
        if (nestedList.get(index).isInteger()) {
            return true;
        }
        if (nestedIterator == null) {
            nestedIterator = new NestedIterator(nestedList.get(index).getList());
        }
        if (nestedIterator.hasNext()) {
            return true;
        }
        nestedIterator = null;
        this.index++;
        return hasNext();
    }
}

