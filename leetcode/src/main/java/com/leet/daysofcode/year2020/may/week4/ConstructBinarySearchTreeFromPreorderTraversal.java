package com.leet.daysofcode.year2020.may.week4;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;
import java.util.Arrays;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        int[][] preorders = {{8, 5, 1, 7, 10, 12}};
        Integer[][] outputs = {{8, 5, 10, 1, 7, null, 12}};
        ConstructBinarySearchTreeFromPreorderTraversal constructBinarySearchTreeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversal();
        for (int i = 0; i < preorders.length; i++) {
            System.out.println("Input -> " + Arrays.toString(preorders[i]));
            TreeNode node = constructBinarySearchTreeFromPreorderTraversal.bstFromPreorder(preorders[i]);
            System.out.println("Output -> " + TreeUtils.levelOrderTraverse(node));
            System.out.println("Expected -> " + Arrays.toString(outputs[i]));
            System.out.println("###################################################");
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode(head, preorder[i]);
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
