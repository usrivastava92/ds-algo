package com.ds.tree.segmenttree;

import com.ds.utils.ArrayUtils;
import com.ds.utils.NumberUtils;

import java.util.Arrays;

public class SegmentTree implements ISegmentTree {

    private final int[] tree;
    private final int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[2 * n];
        buildTree(0, n - 1, arr, 1);
    }

    private void buildTree(int start, int end, int[] arr, int treeIndex) {
        if (!ArrayUtils.isValidIndex(arr, start) || !ArrayUtils.isValidIndex(arr, end) || !ArrayUtils.isValidIndex(tree, treeIndex) || end < start) {
            return;
        }
        if (start == end) {
            tree[treeIndex] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(start, mid, arr, treeIndex * 2);
        buildTree(mid + 1, end, arr, treeIndex * 2 + 1);
        tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
    }


    @Override
    public int rangeQuery(int start, int end) {
        return rangeHelper(start, end, 0, n - 1, 1);
    }

    private int rangeHelper(final int start, final int end, int left, int right, int treeIndex) {
        if (!ArrayUtils.isValidIndex(tree, treeIndex)) {
            return 0;
        }
        if (start == left && end == right) {
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        if (mid < start) {
            return rangeHelper(start, end, mid + 1, right, treeIndex * 2 + 1);
        } else if (mid >= end) {
            return rangeHelper(start, end, left, mid, treeIndex * 2);
        }
        return rangeHelper(start, mid, left, mid, treeIndex * 2) + rangeHelper(mid + 1, end, mid + 1, right, treeIndex * 2 + 1);
    }

    @Override
    public void updateNode(int i, int value) {
        if (!NumberUtils.isInRangeStartInclusive(i, 0, n)) {
            throw new IllegalArgumentException("invalid index");
        }
        updateHelper(i, value, 0, n - 1, 1);
    }

    private void updateHelper(final int i, final int value, int left, int right, int treeIndex) {
        if (!ArrayUtils.isValidIndex(tree, treeIndex)) {
            return;
        }
        if (left == i && right == i) {
            tree[treeIndex] = value;
            return;
        }
        int mid = left + (right - left) / 2;
        if (i <= mid) {
            updateHelper(i, value, left, mid, treeIndex * 2);
        } else {
            updateHelper(i, value, mid + 1, right, treeIndex * 2 + 1);
        }
        tree[treeIndex] = (ArrayUtils.isValidIndex(tree, treeIndex * 2) ? tree[treeIndex * 2] : 0) + (ArrayUtils.isValidIndex(tree, treeIndex * 2 + 1) ? tree[treeIndex * 2 + 1] : 0);
    }

    @Override
    public String toString() {
        return "SegmentTree{" + "tree=" + Arrays.toString(tree) + '}';
    }

}
