package com.leet.ds.stack;

import com.leet.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[][] arrs = {{3, 2, 1, 6, 0, 5}};
        int testCase = 0;

        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        System.out.println(maximumBinaryTree.constructMaximumBinaryTree(arrs[testCase]));
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                System.out.println(curr + ".left  ->  " + stack.peek());
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                System.out.println(stack.peek() + ".right -> " + curr);
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
