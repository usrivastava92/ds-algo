package com.ib.tree;


public class SumRootToLeafNumbersAsked {
    public int sumNumbers(TreeNode A) {
        return sum(A, 0) % 1003;
    }

    public int sum(TreeNode root, int mul) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return (mul * 10 + root.val) % 1003;
        }

        int num = mul * 10 + root.val;
        num %= 1003;
        int ans = (sum(root.left, num) + sum(root.right, num));

        return ans % 1003;
    }
}
