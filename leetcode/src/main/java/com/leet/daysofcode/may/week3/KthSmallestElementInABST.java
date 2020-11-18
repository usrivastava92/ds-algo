package com.leet.daysofcode.may.week3;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInABST {

    public static void main(String[] args) {
        Integer[][] inputs = {{3, 1, 4, null, 2}, {5, 3, 6, 2, 4, null, null, 1}};
        int[] ks = {1, 3};
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        for (int i = 0; i < inputs.length; i++) {
            TreeNode root = TreeUtils.createTreeFromBfsArray(inputs[i]);
            System.out.println(TreeUtils.levelOrderTraverse(root) + " -> " + kthSmallestElementInABST.kthSmallest(root, ks[i]));
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int count = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

}
