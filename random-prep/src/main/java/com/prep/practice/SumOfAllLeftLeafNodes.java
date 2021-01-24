package com.prep.practice;

import com.ds.tree.BinaryTreeNode;
import com.ds.utils.TreeUtils;

public class SumOfAllLeftLeafNodes {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> head = TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(head);
        System.out.println(leftOfAllLeftLeafNode(head));
    }

    private static int leftOfAllLeftLeafNode(BinaryTreeNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        int leftSum = 0;
        if (TreeUtils.isLeaf(head.getLeft())) {
            leftSum = head.getLeft().val;
        } else {
            leftSum = leftOfAllLeftLeafNode(head.getLeft());
        }
        int rightSum = leftOfAllLeftLeafNode(head.getRight());
        return leftSum + rightSum;
    }

}
