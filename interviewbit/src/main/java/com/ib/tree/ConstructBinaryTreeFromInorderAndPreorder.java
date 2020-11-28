package com.ib.tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPreorder {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createRandomBST(20);
        ArrayList<Integer> inorder = TreeUtils.preorderTraversal(treeNode);
        ArrayList<Integer> preorder = TreeUtils.preorderTraversal(treeNode);
        System.out.println(inorder);
        System.out.println(preorder);
        ConstructBinaryTreeFromInorderAndPreorder cons = new ConstructBinaryTreeFromInorderAndPreorder();
        TreeNode node = cons.buildTree(preorder, inorder);
        System.out.println(TreeUtils.inorderTraversal(node).equals(inorder));
        System.out.println(TreeUtils.preorderTraversal(node).equals(preorder));
    }

    int preOrderIndex = 0;

    public TreeNode buildTree(List<Integer> preOrder, List<Integer> inOrder) {
        preOrderIndex = 0;
        return helper(preOrder, inOrder);
    }

    private TreeNode helper(List<Integer> preOrder, List<Integer> inOrder) {
        TreeNode head = new TreeNode(preOrder.get(preOrderIndex++));
        int index = inOrder.indexOf(head.val);
        if (index > 0) {
            head.left = helper(preOrder, inOrder.subList(0, index));
        }
        if (inOrder.size() - (index + 1) > 0) {
            head.right = helper(preOrder, inOrder.subList(index + 1, inOrder.size()));
        }
        return head;
    }


}
