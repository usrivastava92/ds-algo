package com.ib.tree;

public class ValidBinarySearchTree {

    public int isValidBST(TreeNode A) {
        return isValidBST(A, null, null) ? 1 : 0;
    }

    public boolean isValidBST(TreeNode A, Integer max, Integer min) {
        if (A == null) {
            return true;
        }
        return inRange(A.val, max, min) && isValidBST(A.left, A.val, min) && isValidBST(A.right, max, A.val);
    }

    private boolean inRange(int val, Integer max, Integer min) {
        if (max == null && min == null) {
            return true;
        }
        if (max != null && val >= max) {
            return false;
        }
        return min == null || val > min;
    }

}
