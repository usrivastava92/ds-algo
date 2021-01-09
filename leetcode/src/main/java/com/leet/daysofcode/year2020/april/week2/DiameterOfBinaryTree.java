package com.leet.daysofcode.year2020.april.week2;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int leftMax = root==null ? 0 : maxLength(root.left);
        int rightMax = root==null ? 0 : maxLength(root.right);
        return leftMax + rightMax;
    }

    private int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + maxLength(root.left);
        int right = 1 + maxLength(root.right);
        return left > right ? left : right;
    }


}
