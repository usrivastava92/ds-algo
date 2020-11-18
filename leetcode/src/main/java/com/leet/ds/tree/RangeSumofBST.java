package com.leet.ds.tree;

public class RangeSumofBST {


    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBst(10, 5, 15, 3, 7, 13, 18, 1, 6);
        RangeSumofBST rangeSumofBST = new RangeSumofBST();
        int l = 6;
        int r = 10;
        System.out.println(rangeSumofBST.rangeSumBST(root, l, r));
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root != null) {
            if (root.val < L) {
                return rangeSumBST(root.right, L, R);
            }
            if (root.val > R) {
                return rangeSumBST(root.left, L, R);
            }
            sum += root.val;
            sum += rangeSumBST(root.right, L, R);
            sum += rangeSumBST(root.left, L, R);
        }
        return sum;
    }
}
