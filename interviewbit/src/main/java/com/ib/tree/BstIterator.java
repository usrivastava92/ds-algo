package com.ib.tree;

import java.util.ArrayDeque;

public class BstIterator {

    private ArrayDeque<TreeNode> stack = new ArrayDeque<>();

    public BstIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode curr = stack.pop();
        int val = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return val;
    }
}

