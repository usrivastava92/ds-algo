package com.prep.practice;

import com.ds.tree.BinaryTreeNode;
import com.ds.utils.TreeUtils;

import java.util.*;

public class AnticlockTraversalBst {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> head = TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(head);
        System.out.println(anticlockTraversal(head));
    }

    private static List<Integer> anticlockTraversal(BinaryTreeNode<Integer> head) {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0, len = queue.size(); i < len; i++) {
                BinaryTreeNode<Integer> poll = queue.poll();
                level.add(poll.val);
                if (poll.getLeft() != null) {
                    queue.add(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    queue.add(poll.getRight());
                }
            }
            levelOrder.add(level);
        }
        int start = 0;
        int end = levelOrder.size() - 1;
        while (start <= end) {
            for (int i = levelOrder.get(start).size() - 1; i > -1; i--) {
                ans.add(levelOrder.get(start).get(i));
            }
            if (start != end) {
                ans.addAll(levelOrder.get(end));
                end--;
            }
            start++;
        }
        return ans;
    }

}
