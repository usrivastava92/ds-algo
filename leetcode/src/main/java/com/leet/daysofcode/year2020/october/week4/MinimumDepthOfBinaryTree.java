package com.leet.daysofcode.year2020.october.week4;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.stream.IntStream;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[][] inputs = {{3, 9, 20, null, null, 15, 7}, {2, null, 3, null, 4, null, 5, null, 6}, {}};
        int[] outputs = {2, 5, 0};
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            TreeNode node = TreeUtils.createTreeFromBfsArray(inputs[i]);
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(node);
            System.out.println("Output : " + minimumDepthOfBinaryTree.minDepth(node));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
