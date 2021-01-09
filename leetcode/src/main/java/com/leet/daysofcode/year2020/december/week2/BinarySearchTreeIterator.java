package com.leet.daysofcode.year2020.december.week2;

import com.leet.ds.tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public static void main(String[] args) {

    }

    private static final class BSTIterator {

        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
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

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
