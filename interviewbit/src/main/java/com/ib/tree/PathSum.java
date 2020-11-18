package com.ib.tree;

public class PathSum {

    public static void main(String[] args) {

    }

    public int hasPathSum(TreeNode A, int B) {
        if(helper(A, B, 0)){
            return 1;
        }
        return 0;
    }


    public boolean helper(TreeNode A, final int target, int current) {
        if (A.left == null && A.right == null) {
            return (current + A.val) == target;
        }
        current += A.val;
        boolean left = false;
        if(A.left!=null){
            left = helper(A.left, target, current);
        }
        boolean right = false;
        if(A.right!=null){
            right = helper(A.right, target, current);
        }
        return left || right;
    }
}
