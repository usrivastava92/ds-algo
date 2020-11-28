package com.ds.heap;

public interface Heap<T extends Comparable<T>> {

    default int getParentIndex(int childIndex) {
        return ((childIndex + 1) / 2) - 1;
    }


    default int getLeftChildIndex(int parentIndex) {
        return ((parentIndex + 1) * 2) - 1;
    }


    default int getRightChildIndex(int parentIndex) {
        return ((parentIndex + 1) * 2);
    }

    default boolean hasParent(int index) {
        return index != 0;
    }

    void swap(int i, int j);

    boolean isEmpty();

    void addElement(T element);

    boolean isLeaf(int index);

    T removeElement();

    void heapify(int index);

}
