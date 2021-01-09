package com.leet.daysofcode.year2020.december.week1;

import com.leet.ds.tree.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
