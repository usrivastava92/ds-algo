package com.ib.tree;

public class MergeTwoBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return null;
        }
        if (A == null || B == null) {
            return A != null ? A : B;
        }
        A.val = A.val + B.val;
        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right);
        return A;
    }

}
