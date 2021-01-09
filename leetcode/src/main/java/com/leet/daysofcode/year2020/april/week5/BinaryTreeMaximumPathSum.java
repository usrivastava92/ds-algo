package com.leet.daysofcode.year2020.april.week5;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTreeFromBfsArray(-10, 9, 20, null, null, 15, 7);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(TreeUtils.getLevelOrderTraverseListLevelWise(root));
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        int continuousSum = Math.max(Math.max(left, right) + node.val, node.val);
        int includingNodeSum = Math.max(continuousSum, left + right + node.val);

        if (includingNodeSum > maxSum) {
            maxSum = includingNodeSum;
        }

        return continuousSum;
    }
}