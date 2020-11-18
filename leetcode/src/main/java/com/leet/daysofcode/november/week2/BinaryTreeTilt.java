package com.leet.daysofcode.november.week2;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.stream.IntStream;

public class BinaryTreeTilt {

    public static void main(String[] args) {
        TreeNode[] heads = {TreeUtils.createTreeFromBfsArray(1, 2, 3), TreeUtils.createTreeFromBfsArray(4, 2, 9, 3, 5, null, 7), TreeUtils.createTreeFromBfsArray(21, 7, 14, 1, 1, 2, 2, 3, 3)};
        int[] outputs = {1, 15, 9};
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        IntStream.range(0, heads.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(heads[i]);
            System.out.println("Output : " + binaryTreeTilt.findTilt(heads[i]));
            TreeUtils.prettyPrintTree(heads[i]);
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int findTilt(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return 0;
        }
        int sum = findTilt(root.left) + findTilt(root.right) + Math.abs((root.left == null ? 0 : root.left.val) - (root.right == null ? 0 : root.right.val));
        root.val = root.val + (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

}
