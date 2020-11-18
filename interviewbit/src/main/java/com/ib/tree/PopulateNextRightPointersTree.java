package com.ib.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulateNextRightPointersTree {

    public void connect(TreeLinkNode root) {
        if (root != null) {
            Queue<TreeLinkNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                int size = queue.size();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                for (int i = 0; i < size; i++) {
                    TreeLinkNode temp = queue.poll();
                    node.next = temp;
                    node = node.next;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}