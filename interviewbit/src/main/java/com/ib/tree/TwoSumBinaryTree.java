package com.ib.tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TwoSumBinaryTree {
    public int t2Sum(TreeNode A, int B) {
        if (A != null) {
            Set<Integer> set = new HashSet<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                int find = B - node.val;
                if (set.contains(find)) {
                    return 1;
                }
                set.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return 0;
    }
}
