package com.ib.tree;

import java.util.*;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null || A.val == B) {
            return ans;
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(A, null));
        int level = 0;
        int bLevel = -1;
        TreeNode bParent = null;
        while (!queue.isEmpty()) {
            if (bLevel == level) {
                for (int i = 0, len = queue.size(); i < len; i++) {
                    Pair poll = queue.poll();
                    if (!poll.parent.equals(bParent)) {
                        ans.add(poll.node.val);
                    }
                }
                break;
            } else {
                for (int i = 0, len = queue.size(); i < len; i++) {
                    Pair poll = queue.poll();
                    if (poll.node.left != null) {
                        if (poll.node.left.val == B) {
                            bParent = poll.node;
                            bLevel = level + 1;
                        }
                        queue.add(new Pair(poll.node.left, poll.node));
                    }
                    if (poll.node.right != null) {
                        if (poll.node.right.val == B) {
                            bParent = poll.node;
                            bLevel = level + 1;
                        }
                        queue.add(new Pair(poll.node.right, poll.node));
                    }
                }
            }
            level++;
        }
        return ans;
    }

    private static final class Pair {
        TreeNode node;
        TreeNode parent;

        public Pair(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}
