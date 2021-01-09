package com.leet.daysofcode.year2020.october.week5;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode[] inputs = {TreeUtils.createTreeFromBfsArray(1, 3, null, null, 2), TreeUtils.createTreeFromBfsArray(3, 1, 4, null, null, 2)};
        TreeNode[] outputs = {TreeUtils.createTreeFromBfsArray(3, 1, null, null, 2), TreeUtils.createTreeFromBfsArray(2, 1, 4, null, null, 3)};
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(inputs[i]);
            System.out.println("Output : ");
            recoverBinarySearchTree.recoverTree(inputs[i]);
            TreeUtils.prettyPrintTree(inputs[i]);
            System.out.println("Expected : ");
            TreeUtils.prettyPrintTree(outputs[i]);
        });
    }

    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val < prev.val) {
                if (firstNode == null) {
                    firstNode = prev;
                    secondNode = curr;
                } else {
                    secondNode = curr;
                    break;
                }
            }
            prev = curr;
            curr = curr.right;
        }
        if (firstNode != null) {
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }

}
