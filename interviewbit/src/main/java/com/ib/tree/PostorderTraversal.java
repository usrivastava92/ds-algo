package com.ib.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.empty()) {
                curr = stack.pop();
                if (!stack.empty() && stack.peek() == curr) {
                    curr = curr.right;
                } else {
                    arrayList.add(curr.val);
                    curr = null;
                }
            }
        }
        return arrayList;
    }
}
