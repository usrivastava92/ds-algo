package com.ib.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
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
}
