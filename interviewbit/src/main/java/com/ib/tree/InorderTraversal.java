package com.ib.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = A;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            arrayList.add(curr.val);
            curr = curr.right;
        }
        return arrayList;
    }
}

