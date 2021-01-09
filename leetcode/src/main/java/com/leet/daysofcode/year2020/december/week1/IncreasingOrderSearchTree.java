package com.leet.daysofcode.year2020.december.week1;

import com.leet.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncreasingOrderSearchTree {


    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorder.add(root);
            root = root.right;
        }
        int len = inorder.size();
        for (int i = 0; i < len; i++) {
            root = inorder.get(i);
            root.left = null;
            root.right = i + 1 < len ? inorder.get(i + 1) : null;
        }
        return inorder.get(0);
    }


}
