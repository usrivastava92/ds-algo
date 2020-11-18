package com.leet.daysofcode.july.week1;

import com.ds.utils.ArrayUtils;
import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.*;
import java.util.stream.IntStream;

public class BinaryTreeLevelOrderTraversal2 {

    public static void main(String[] args) {
        Integer[][] inputs = {{null}, {3, 9, 20, null, null, 15, 7}};
        Integer[][][] expectedOutputs = {{}, {{15, 7}, {9, 20}, {3}}};
        BinaryTreeLevelOrderTraversal2 binaryTreeLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
        for (int i = 0, len = inputs.length; i < len; i++) {
            TreeNode treeNode = TreeUtils.createTreeFromBfsArray(inputs[i]);
            System.out.println("Input : " + ArrayUtils.toString(inputs));
            System.out.println("Output : " + binaryTreeLevelOrderTraversal2.levelOrderBottom(treeNode));
            System.out.println("Excepted Output : " + ArrayUtils.toString(expectedOutputs[i]));
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> answer = new LinkedList<>();
        if (root == null) {
            return answer;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            IntStream.range(0, queue.size()).forEach(i -> {
                TreeNode poll = queue.poll();
                row.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            });
            answer.push(row);
        }
        return answer;
    }
}
