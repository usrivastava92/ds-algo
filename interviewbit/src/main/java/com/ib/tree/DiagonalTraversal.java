package com.ib.tree;

import java.util.*;

public class DiagonalTraversal {

    public static void main(String[] args) {
        TreeNode head = TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(head);
        DiagonalTraversal diagonalTraversal  = new DiagonalTraversal();
        System.out.println(diagonalTraversal.solve(head));
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Map<Integer, ArrayDeque<TreeNode>> levelMap = new HashMap<>();
        int level = 0;
        addToMapQueue(levelMap, level, root);
        while (!levelMap.isEmpty()) {
            ArrayDeque<TreeNode> levelQueue = levelMap.get(level);
            while (!levelQueue.isEmpty()) {
                TreeNode node = levelQueue.poll();
                while (node != null) {
                    traversal.add(node.val);
                    if (node.left != null) {
                        addToMapQueue(levelMap, level + 1, node.left);
                    }
                    node = node.right;
                }
            }
            levelMap.remove(level);
            level++;
        }
        return traversal;
    }

    private void addToMapQueue(Map<Integer, ArrayDeque<TreeNode>> map, int level, TreeNode node) {
        ArrayDeque<TreeNode> queue = map.getOrDefault(level , new ArrayDeque<>());
        queue.add(node);
        map.put(level, queue);
    }

}
