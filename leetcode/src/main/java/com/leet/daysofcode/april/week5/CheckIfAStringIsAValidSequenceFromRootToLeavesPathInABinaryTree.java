package com.leet.daysofcode.april.week5;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

    public static void main(String[] args) {
        TreeNode[] roots = {TreeUtils.createTreeFromBfsArray(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), TreeUtils.createTreeFromBfsArray(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0)};
        int[][] arrs = {{0, 1, 0, 1}, {0, 1, 1}};
        int testCase = 0;
        CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree chk = new CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree();
        System.out.println(chk.isValidSequence(roots[testCase], arrs[testCase]));
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (arr == null || arr.length == 0 || root == null) {
            return false;
        }
        return helper(root, arr, 0);
    }

    public boolean helper(TreeNode root, final int[] arr, int i) {
        if (i >= arr.length || root == null) {
            return false;
        }
        if (i == (arr.length - 1) && TreeUtils.isLeaf(root) && root.val == arr[i]) {
            return true;
        }
        if (root.val != arr[i]) {
            return false;
        }
        i++;
        return helper(root.left, arr, i) || helper(root.right, arr, i);
    }

}
