package com.ib.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createRandomBST(10);
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(treeNode);
    }

    public ArrayList<Integer> recoverTree(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node != null) {
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = node;
            Integer previous = null;
            Integer first = null;
            Integer second = null;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (previous == null) {
                    previous = curr.val;
                } else {
                    if (previous > curr.val) {
                        if (first == null) {
                            first = previous;
                        }
                        second = curr.val;
                    }
                    previous = curr.val;
                }
                curr = curr.right;
            }
            result.add(first);
            result.add(second);
            Collections.sort(result);
        }
        return result;
    }

}
