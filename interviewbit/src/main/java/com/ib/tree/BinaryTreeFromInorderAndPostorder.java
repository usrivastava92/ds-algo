package com.ib.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int input = new Double(Math.random() * 100).intValue();
            while (input == 0) {
                input = new Double(Math.random() * 100).intValue();
            }
            TreeNode treeNode = TreeUtils.createRandomBST(input);
            ArrayList<Integer> postOrder = TreeUtils.postorderTraversal(treeNode);
            ArrayList<Integer> inOrder = TreeUtils.inorderTraversal(treeNode);
            ArrayList<Integer> preOrder = TreeUtils.preorderTraversal(treeNode);
            System.out.println(postOrder);
            System.out.println(inOrder);
            System.out.println(preOrder);
            BinaryTreeFromInorderAndPostorder binaryTreeFromInorderAndPostorder = new BinaryTreeFromInorderAndPostorder();
            TreeNode node = binaryTreeFromInorderAndPostorder.buildTree(postOrder, inOrder);
            System.out.println(TreeUtils.postorderTraversal(node).equals(postOrder) && TreeUtils.inorderTraversal(node).equals(inOrder));
        }
    }

    int postOrderIndex = 0;
    public TreeNode buildTree(List<Integer> postOrder, List<Integer> inOrder) {
        postOrderIndex = postOrder.size() - 1;
        return helper(postOrder, inOrder);
    }

    private TreeNode helper(List<Integer> postOrder, List<Integer> inOrder) {
        TreeNode head = new TreeNode(postOrder.get(postOrderIndex--));
        int index = inOrder.indexOf(head.val);
        if (inOrder.size() - (index + 1) > 0) {
            head.right = helper(postOrder, inOrder.subList(index + 1, inOrder.size()));
        }
        if (index > 0) {
            head.left = helper(postOrder, inOrder.subList(0, index));
        }
        return head;
    }
}
