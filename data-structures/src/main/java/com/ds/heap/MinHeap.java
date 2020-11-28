package com.ds.heap;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {

    private ArrayList<T> array = new ArrayList<>();

    public MinHeap() {
    }

    public MinHeap(T element) {
        array.add(element);
    }

    @Override
    public void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void addElement(T element) {
        array.add(element);
        if (array.size() > 1) {
            heapify(array.size() - 1);
        }
    }

    @Override
    public boolean isLeaf(int index) {
        return getLeftChildIndex(index) <= (array.size() - 1);
    }

    @Override
    public T removeElement() {
        if (!array.isEmpty()) {
            if (array.size() == 1) {
                return array.remove(0);
            }
            T element = array.get(0);
            array.set(0, array.remove(array.size() - 1));
            heapify(0);
            return element;
        }
        return null;
    }

    @Override
    public void heapify(int i) {
        int currIndex = i;
        int parentIndex = getParentIndex(currIndex);
        while (hasParent(currIndex) && array.get(parentIndex).compareTo(array.get(currIndex)) > 0) {
            swap(currIndex, parentIndex);
            currIndex = parentIndex;
            parentIndex = getParentIndex(currIndex);
        }
        currIndex = i;
        boolean descendLeft = false;
        boolean descendRight = false;
        int leftChildIndex = getLeftChildIndex(currIndex);
        int rightChildIndex = getRightChildIndex(currIndex);
        if ((leftChildIndex < array.size()) && (array.get(leftChildIndex).compareTo(array.get(currIndex)) < 0)) {
            descendLeft = true;
        }
        if ((rightChildIndex < array.size()) && (array.get(rightChildIndex).compareTo(array.get(currIndex)) < 0)) {
            descendRight = true;
        }
        if (descendLeft && descendRight) {
            if (array.get(leftChildIndex).compareTo(array.get(rightChildIndex)) < 0) {
                descendLeft = true;
                descendRight = false;
            } else {
                descendLeft = false;
                descendRight = true;
            }
        }
        while (descendLeft || descendRight) {
            if (descendLeft) {
                swap(leftChildIndex, currIndex);
                currIndex = leftChildIndex;
            }
            if (descendRight) {
                swap(rightChildIndex, currIndex);
                currIndex = rightChildIndex;
            }
            leftChildIndex = getLeftChildIndex(currIndex);
            rightChildIndex = getRightChildIndex(currIndex);
            descendLeft = false;
            descendRight = false;
            if ((leftChildIndex < array.size()) && (array.get(leftChildIndex).compareTo(array.get(currIndex)) < 0)) {
                descendLeft = true;
            }
            if ((rightChildIndex < array.size()) && (array.get(rightChildIndex).compareTo(array.get(currIndex)) < 0)) {
                descendRight = true;
            }
            if (descendLeft && descendRight) {
                if (array.get(leftChildIndex).compareTo(array.get(rightChildIndex)) < 0) {
                    descendLeft = true;
                    descendRight = false;
                } else {
                    descendLeft = false;
                    descendRight = true;
                }
            }
        }
    }
}
