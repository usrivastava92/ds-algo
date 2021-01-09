package com.leet.daysofcode.year2020.april.week3;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

public class ConstructBinarySearchTreeFromPreorderTraversal {


    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal cons = new ConstructBinarySearchTreeFromPreorderTraversal();
        int[] preorder = new int[]{8, 5, 1, 7, 10, 12};
        System.out.println(TreeUtils.preorderTraversal(cons.bstFromPreorder(preorder)));
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = null;
        if (preorder != null && preorder.length > 0) {
            head = new TreeNode(preorder[0]);
            for (int i = 1; i < preorder.length; i++) {
                insertNode(head, preorder[i]);
            }
        }
        return head;
    }

    public void insertNode(TreeNode node, int value) {
        if (value > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                insertNode(node.right, value);
            }
        } else if (value < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                insertNode(node.left, value);
            }
        }
    }

}
