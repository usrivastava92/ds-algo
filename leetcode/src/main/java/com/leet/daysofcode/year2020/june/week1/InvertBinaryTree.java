package com.leet.daysofcode.year2020.june.week1;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode[] input = {TreeUtils.createBst(6, 2, 1, 3, 7, 8, 9, 0)};
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(input[i]);
            System.out.println("#####################################");
            System.out.println("Output : ");
            TreeUtils.prettyPrintTree(invertBinaryTree.invertTree(input[i]));
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
