package com.ib.dp;

import com.ib.tree.TreeNode;
import com.ib.tree.TreeUtils;

import java.util.*;
import java.util.stream.IntStream;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int[] inputs = {3};
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            for (TreeNode treeNode : uniqueBinarySearchTrees.generateTrees(inputs[i])) {
                TreeUtils.prettyPrintTree(treeNode);
                System.out.println("######################");
            }
        });
    }

    public ArrayList<TreeNode> generateTrees(int a) {
        return generateTrees(1, a);
    }

    Map<Pair, ArrayList<TreeNode>> dp = new HashMap<>();

    public ArrayList<TreeNode> generateTrees(int low, int high) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (high < low) {
            list.add(null);
            return list;
        }
        Pair pair = new Pair(low, high);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }
        for (int i = low; i <= high; i++) {
            ArrayList<TreeNode> lefts = generateTrees(low, i - 1);
            ArrayList<TreeNode> rights = generateTrees(i + 1, high);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    list.add(head);
                }
            }
        }
        dp.put(pair, list);
        return list;
    }

    private static class Pair {
        private int low;
        private int high;

        public Pair(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return low == pair.low &&
                    high == pair.high;
        }

        @Override
        public int hashCode() {
            return Objects.hash(low, high);
        }
    }
}
