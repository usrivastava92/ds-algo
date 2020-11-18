package com.leet.daysofcode.november.week3;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.stream.IntStream;

public class RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode[] treeNodes = {TreeUtils.createTreeFromBfsArray(10, 5, 15, 3, 7, null, 18), TreeUtils.createTreeFromBfsArray(10, 5, 15, 3, 7, 13, 18, 1, null, 6)};
        int[] lows = {7, 6};
        int[] highs = {15, 10};
        int[] outputs = {32, 23};
        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        IntStream.range(0, treeNodes.length).forEachOrdered(i -> {
            System.out.println("Input : low : " + lows[i] + " high : " + highs[i]);
            TreeUtils.prettyPrintTree(treeNodes[i]);
            System.out.println("Output : " + rangeSumOfBST.rangeSumBST(treeNodes[i], lows[i], highs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (inRange(root.val, low, high)) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high);
    }

    private boolean inRange(int num, int low, int high) {
        return num >= low && num <= high;
    }


}
