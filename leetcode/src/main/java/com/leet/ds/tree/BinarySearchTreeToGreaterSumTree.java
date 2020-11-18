package com.leet.ds.tree;

public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTreeFromBfsArray(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        System.out.println(TreeUtils.levelOrderTraverse(root));
        BinarySearchTreeToGreaterSumTree binarySearchTreeToGreaterSumTree = new BinarySearchTreeToGreaterSumTree();
        binarySearchTreeToGreaterSumTree.bstToGst(root);
        System.out.println(TreeUtils.levelOrderTraverse(root));
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode root, int prevSum) {
        if (root == null) {
            return prevSum;
        }
        prevSum = helper(root.right, prevSum);
        root.val = prevSum + root.val;
        prevSum = root.val;
        prevSum = helper(root.left, prevSum);
        return prevSum;
    }

}
