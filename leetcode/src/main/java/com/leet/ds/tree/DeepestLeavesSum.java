package com.leet.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum {

    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        System.out.println(deepestLeavesSum.deepestLeavesSum(null));
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int lastSum = 0;
            while (!queue.isEmpty()) {
                lastSum = 0;
                for (int i = 0, len = queue.size(); i < len; i++) {
                    root = queue.poll();
                    if (root.left == null && root.right == null) {
                        lastSum += root.val;
                    }
                    if (root.left != null) {
                        queue.add(root.left);
                    }
                    if (root.right != null) {
                        queue.add(root.right);
                    }
                }
            }
            return lastSum;
        }
        return -1;
    }

}
