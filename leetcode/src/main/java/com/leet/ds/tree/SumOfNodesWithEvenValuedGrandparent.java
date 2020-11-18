package com.leet.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumOfNodesWithEvenValuedGrandparent {

    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                boolean isEven = root.val % 2 == 0;
                if (root.left != null) {
                    queue.add(root.left);
                    if (isEven) {
                        if (root.left.left != null) {
                            sum += root.left.left.val;
                        }
                        if (root.left.right != null) {
                            sum += root.left.right.val;
                        }
                    }
                }
                if (root.right != null) {
                    queue.add(root.right);
                    if (isEven) {
                        if (root.right.left != null) {
                            sum += root.right.left.val;
                        }
                        if (root.right.right != null) {
                            sum += root.right.right.val;
                        }
                    }
                }
            }
        }
        return sum;
    }

}
