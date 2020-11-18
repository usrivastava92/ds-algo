package com.leet.ds.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }


}

class MedianFinder {

    private PriorityQueue<Integer> lowerHalfMaxHeap;
    private PriorityQueue<Integer> upperHalfMinHeap;

    public MedianFinder() {
        lowerHalfMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        upperHalfMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lowerHalfMaxHeap.isEmpty() || num < lowerHalfMaxHeap.peek()) {
            lowerHalfMaxHeap.add(num);
        } else {
            upperHalfMinHeap.add(num);
        }
        balance();
    }

    private void balance() {
        int diff = lowerHalfMaxHeap.size() - upperHalfMinHeap.size();
        if (diff > 1) {
            upperHalfMinHeap.add(lowerHalfMaxHeap.poll());
        } else if (diff < -1) {
            lowerHalfMaxHeap.add(upperHalfMinHeap.poll());
        }
    }

    public double findMedian() {
        if (upperHalfMinHeap.size() > lowerHalfMaxHeap.size()) {
            return upperHalfMinHeap.peek();
        } else if (lowerHalfMaxHeap.size() > upperHalfMinHeap.size()) {
            return lowerHalfMaxHeap.peek();
        } else {
            return (lowerHalfMaxHeap.peek() + upperHalfMinHeap.peek()) / 2.0;
        }
    }
}
