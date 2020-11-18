package com.ds.tree.segmenttree;

import com.ds.tree.BinaryTreeNode;

public class NodeSegmentTree implements SegmentTree {

    private BinaryTreeNode<Integer> tree;
    private int n;

    public NodeSegmentTree(int[] arr) {
        if (arr != null && arr.length > 0) {
            n = arr.length;
            tree = createTree(arr, 0, n - 1);
        }
    }

    private BinaryTreeNode<Integer> createTree(int[] arr, int start, int end) {
        if (start == end) {
            return new BinaryTreeNode<>(arr[start]);
        }
        int mid = start + (end - start) / 2;
        BinaryTreeNode<Integer> left = createTree(arr, start, mid);
        BinaryTreeNode<Integer> right = createTree(arr, mid + 1, end);
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(left.val + right.val);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    @Override
    public int rangeQuery(int i, int j) {
        if (tree == null) {
            return 0;
        }
        return rangeQueryHelper(0, n - 1, i, j, tree);
    }

    public int rangeQueryHelper(int start, int end, int i, int j, BinaryTreeNode<Integer> segTree) {
        if (start > j || end < i) {
            return 0;
        }
        if (start == i && end == j) {
            return segTree.val;
        }
        int mid = start + (end - start) / 2;
        if (i <= mid && j <= mid) {
            return rangeQueryHelper(start, mid, i, j, segTree.getLeft());
        }
        if (i > mid && j > mid) {
            return rangeQueryHelper(mid + 1, end, i, j, segTree.getRight());
        }
        int left = rangeQueryHelper(start, mid, i, mid, segTree.getLeft());
        int right = rangeQueryHelper(mid + 1, end, mid + 1, j, segTree.getRight());
        return left + right;
    }

    @Override
    public void updateNode(int i, int value) {

    }
}
