package com.ib.tree;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createRandomBST(5);
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(treeNode);
    }

    public TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }
        TreeNode left = flatten(a.left);
        TreeNode right = flatten(a.right);
        if (left != null) {
            a.left = null;
            a.right = left;
            TreeNode temp = a.right;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
        }
        return a;
    }
}
