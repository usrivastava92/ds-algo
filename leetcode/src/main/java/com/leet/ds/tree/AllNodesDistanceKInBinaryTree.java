package com.leet.ds.tree;

import java.util.*;
import java.util.stream.IntStream;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        TreeNode[] roots = {TreeUtils.createTreeFromBfsArray(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), TreeUtils.createTreeFromBfsArray(0, 1, null, 3, 2), TreeUtils.createTreeFromBfsArray(0, 2, 1, null, null, 3)};
        int[] targets = {5, 2, 3};
        int[] ks = {2, 1, 3};
        int[][] outputs = {{7, 4, 1}, {1}, {2}};
        AllNodesDistanceKInBinaryTree allNodesDistanceKInBinaryTree = new AllNodesDistanceKInBinaryTree();
        IntStream.range(0, roots.length).forEachOrdered(i -> {
            System.out.println("Input : target -> " + targets[i] + ", k -> " + ks[i]);
            TreeUtils.prettyPrintTree(roots[i]);
            System.out.println("Output : " + allNodesDistanceKInBinaryTree.distanceK(roots[i], new TreeNode(targets[i]), ks[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        distanceK(root, target, K, ans);
        return ans;
    }

    public int distanceK(TreeNode root, TreeNode target, int k, List<Integer> ans) {
        if (root == null) {
            return -1;
        }
        if (root.equals(target)) {
            addChildAtDistK(root, k, ans);
            return 1;
        }
        int leftDist = distanceK(root.left, target, k, ans);
        if (leftDist == k) {
            ans.add(root.val);
            return -1;
        } else if (leftDist > 0) {
            addChildAtDistK(root.right, k - leftDist - 1, ans);
            return leftDist + 1;
        }
        int rightDist = distanceK(root.right, target, k, ans);
        if (rightDist == k) {
            ans.add(root.val);
            return -1;
        } else if (rightDist > 0) {
            addChildAtDistK(root.left, k - rightDist - 1, ans);
            return rightDist + 1;
        }
        return -1;
    }

    private void addChildAtDistK(TreeNode root, int k, List<Integer> ans) {
        if (root == null || k < 0) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int dist = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.poll();
                if (dist == k) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            dist++;
        }
    }

}
