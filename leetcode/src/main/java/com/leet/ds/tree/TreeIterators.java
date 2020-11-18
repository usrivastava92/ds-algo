package com.leet.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeIterators {

    public static class InorderIterator {

        private Deque<TreeNode> stack;
        private TreeNode curr = null;

        public InorderIterator(TreeNode node) {
            stack = new ArrayDeque<>();
            curr = node;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        public TreeNode next() {
            curr = stack.pop();
            TreeNode returnVal = curr;
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return returnVal;
        }

        public TreeNode peekNext() {
            return stack.peek();
        }


        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }

    public static class PreorderIterator {
        public PreorderIterator(TreeNode node) {

        }
    }

    public static class PostorderIterator {
        public PostorderIterator(TreeNode node) {

        }
    }

}
