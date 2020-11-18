package com.leet.daysofcode.november.week2;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.stream.IntStream;

public class MaximumDifferenceBetweenNodeAndAncestor {

    public static void main(String[] args) {
        TreeNode[] inputs = {TreeUtils.createTreeFromBfsArray(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), TreeUtils.createTreeFromBfsArray(1, null, 2, null, 0, 3)};
        int[] outputs = {7, 3};
        MaximumDifferenceBetweenNodeAndAncestor maximumDifferenceBetweenNodeAndAncestor = new MaximumDifferenceBetweenNodeAndAncestor();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(inputs[i]);
            System.out.println("Output : " + maximumDifferenceBetweenNodeAndAncestor.maxAncestorDiff(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val, 0);
    }

    private int maxAncestorDiff(TreeNode root, int maxAncestor, int minAncestor, int maxDiffTillNow) {
        if (root == null) {
            return maxDiffTillNow;
        }
        maxDiffTillNow = Math.max(maxDiffTillNow, Math.max(Math.abs(root.val - maxAncestor), Math.abs(root.val - minAncestor)));
        int left = maxAncestorDiff(root.left, Math.max(maxAncestor, root.val), Math.min(minAncestor, root.val), maxDiffTillNow);
        int right = maxAncestorDiff(root.right, Math.max(maxAncestor, root.val), Math.min(minAncestor, root.val), maxDiffTillNow);
        return Math.max(left, right);
    }

}
