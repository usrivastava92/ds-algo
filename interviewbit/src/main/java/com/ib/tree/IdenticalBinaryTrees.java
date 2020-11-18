package com.ib.tree;

import java.util.ArrayList;
import java.util.Stack;

public class IdenticalBinaryTrees {

    public static void main(String[] args) {
        IdenticalBinaryTrees identicalBinaryTrees = new IdenticalBinaryTrees();
        System.out.println(identicalBinaryTrees.isIdentical(null, null));
    }

    public int isIdentical(TreeNode A, TreeNode B) {
        if (preorderTraversal(A).equals(preorderTraversal(B))) {
            if (inorderTraversal(A).equals(inorderTraversal(B))) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (A != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = A;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    traversal.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return traversal;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            traversal.add(curr.val);
            curr = curr.right;
        }
        return traversal;
    }
}
