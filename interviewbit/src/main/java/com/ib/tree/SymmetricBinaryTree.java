package com.ib.tree;

public class SymmetricBinaryTree {



    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSym(A.left, A.right);
    }

    public int isSym(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        if (isSym(A.left, B.right) == 1 && isSym(A.right, B.left) == 1) {
            return 1;
        }
        return 0;
    }
}
