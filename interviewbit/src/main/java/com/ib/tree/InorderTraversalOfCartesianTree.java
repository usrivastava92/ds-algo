package com.ib.tree;

import java.util.ArrayList;
import java.util.Collections;

public class InorderTraversalOfCartesianTree {
    public static void main(String[] args) {


    }

    public TreeNode buildTree(ArrayList<Integer> a) {
        if (a == null || a.size() == 0)
            return null;
        TreeNode root = buildTree(a, 0, a.size() - 1);
        return root;
    }

    public TreeNode buildTree(ArrayList<Integer> a, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (max < a.get(i)) {
                max = a.get(i);
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (start == end) {
            return root;
        }
        root.left = buildTree(a, start, maxIndex - 1);
        root.right = buildTree(a, maxIndex + 1, end);
        return root;
    }

}
