package com.leet.daysofcode.year2020.december.week2;

import com.leet.ds.tree.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {

    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int height = getHeight(root);
        if (height <= 2) {
            return root;
        }
        return helper(root, 1, height);
    }


    public TreeNode helper(TreeNode root, int currHeight, int max) {
        if (root == null) {
            return null;
        }
        if (currHeight == max) {
            return root;
        }
        TreeNode left = helper(root.left, currHeight + 1, max);
        TreeNode right = helper(root.right, currHeight + 1, max);
        if (left == null && right == null) {
            return null;
        }
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        return root;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
