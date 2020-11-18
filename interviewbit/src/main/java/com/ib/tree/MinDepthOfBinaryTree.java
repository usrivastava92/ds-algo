package com.ib.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        MinDepthOfBinaryTree minDepthOfBinaryTree = new MinDepthOfBinaryTree();
        System.out.println(minDepthOfBinaryTree.minDepth(null));
    }

    public int minDepth(TreeNode A) {
        int minLevel = 0;
        if (A != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            while (!queue.isEmpty()) {
                minLevel++;
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return minLevel;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return minLevel;
    }
}
