package com.ib.tree;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeUtils.createTreeFromBfsArray(460, 3871, 4698, 8399, 504, 4421, 7515, null, 4167, 5727, null, null, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, null, 6906, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        TreeUtils.prettyPrintTree(node);
        VerticalOrderTraversalOfBinaryTree verticalOrderTraversalOfBinaryTree = new VerticalOrderTraversalOfBinaryTree();
        System.out.println(verticalOrderTraversalOfBinaryTree.verticalOrderTraversal(node));
    }


    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null) {
            return ans;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(A, 0));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            ArrayList<Integer> list = map.getOrDefault(poll.level, new ArrayList<>());
            list.add(poll.node.val);
            map.put(poll.level, list);
            if (poll.node.left != null) {
                queue.add(new Pair(poll.node.left, poll.level - 1));
            }
            if (poll.node.right != null) {
                queue.add(new Pair(poll.node.right, poll.level + 1));
            }
        }
        if (map.isEmpty()) {
            return ans;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }


}
