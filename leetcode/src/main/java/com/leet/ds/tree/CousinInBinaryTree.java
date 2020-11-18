package com.leet.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root != null) {
            int xParent = -1;
            int yParent = -1;
            int xHeight = -1;
            int yHeight = -1;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int height = 0;
            while (!queue.isEmpty()) {
                height++;
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode node = queue.poll();
                    if (xHeight != -1 && yHeight != -1) {
                        System.out.println(xHeight + " " + xParent + " " + yHeight + " " + yParent);
                        break;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                        if (node.left.val == x) {
                            xParent = node.val;
                            xHeight = height + 1;
                        }
                        if (node.left.val == y) {
                            yParent = node.val;
                            yHeight = height + 1;
                        }
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        if (node.right.val == x) {
                            xParent = node.val;
                            xHeight = height + 1;
                        }
                        if (node.right.val == y) {
                            yParent = node.val;
                            yHeight = height + 1;
                        }
                    }
                }
            }
            return (xParent == yParent) && (xHeight == yHeight);
        }
        return false;
    }
}
