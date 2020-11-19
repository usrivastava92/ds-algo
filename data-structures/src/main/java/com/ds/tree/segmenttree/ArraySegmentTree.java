package com.ds.tree.segmenttree;

import java.util.Arrays;

public class ArraySegmentTree implements SegmentTree {

    private final int[] tree;

    public ArraySegmentTree(int[] arr) {
        int n = arr.length;
        tree = new int[3 * n];
        createSegmentTreeHelper(arr, 0, n - 1, 1);
    }

    private void createSegmentTreeHelper(int[] arr, int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * index;
        int rightChild = leftChild + 1;
        createSegmentTreeHelper(arr, start, mid, leftChild);
        createSegmentTreeHelper(arr, mid + 1, end, rightChild);
        tree[index] = tree[leftChild] + tree[rightChild];
    }

    @Override
    public void updateNode(int index, int value) {
        int end = (tree.length / 2) - 1;
        int start = 0;
        if (index < start || index > end) {
            System.out.println("Invalid Index..!!");
            return;
        }
        int diff = value - rangeQuery(index, index);
        int segmentIndex = 1;
        while (start != end) {
            tree[segmentIndex] += diff;
            int mid = start + (end - start) / 2;
            if (start <= index && index <= mid) {
                segmentIndex = segmentIndex * 2;
                end = mid;
            } else {
                segmentIndex = (segmentIndex * 2) + 1;
                start = mid + 1;
            }
        }
        tree[segmentIndex] += diff;
    }

    @Override
    public int rangeQuery(int inStart, int inEnd) {
        int end = getSizeOfInputArr() - 1;
        int start = 0;
        if (start > end || inStart < start || inStart > end || inEnd < start || inEnd > end) {
            throw new RuntimeException("Invalid range value");
        }
        return getRangeSumHelper(start, end, inStart, inEnd, 1);
    }

    private int getRangeSumHelper(int start, int end, int i, int j, int index) {
        if (start == i && end == j) {
            return tree[index];
        }
        if (start > j || end < i) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * index;
        int rightChild = leftChild + 1;
        if (i <= mid && j <= mid) {
            return getRangeSumHelper(start, mid, i, j, leftChild);
        } else if (i > mid && j > mid) {
            return getRangeSumHelper(mid + 1, end, i, j, rightChild);
        }
        int left = getRangeSumHelper(start, mid, i, mid, leftChild);
        int right = getRangeSumHelper(mid + 1, end, mid + 1, j, rightChild);
        return left + right;
    }

    private int getSizeOfInputArr() {
        return tree.length / 3;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "segTree=" + Arrays.toString(tree) +
                '}';
    }
}
