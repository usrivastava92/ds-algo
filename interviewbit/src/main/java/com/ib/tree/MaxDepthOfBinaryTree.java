package com.ib.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        System.out.println(maxDepthOfBinaryTree.maxDepth(null));
    }

    public int maxDepth(TreeNode A) {
        int maxDepth = 0;
        if (A != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            while (!queue.isEmpty()) {
                maxDepth++;
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        return maxDepth;
    }

}
