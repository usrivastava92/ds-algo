package com.leet.daysofcode.year2020.december.week5;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PseudoPalindromicPathsInABinaryTree {

    public static void main(String[] args) {
        TreeNode[] inputs = {TreeUtils.createTreeFromBfsArray(2, 3, 1, 3, 1, null, 1), TreeUtils.createTreeFromBfsArray(2, 1, 1, 1, 3, null, null, null, null, null, 1), TreeUtils.createTreeFromBfsArray(1)};
        int[] outputs = {2, 1, 1};
        PseudoPalindromicPathsInABinaryTree pseudoPalindromicPathsInABinaryTree = new PseudoPalindromicPathsInABinaryTree();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(inputs[i]);
            int output = pseudoPalindromicPathsInABinaryTree.pseudoPalindromicPaths(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPaths(root, new HashMap<>());
    }

    private int pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (isLeaf(root)) {
            boolean isPalindrome = isPalindrome(map);
            map.put(root.val, map.get(root.val) - 1);
            return isPalindrome ? 1 : 0;
        }
        int count = pseudoPalindromicPaths(root.left, map) + pseudoPalindromicPaths(root.right, map);
        map.put(root.val, map.get(root.val) - 1);
        return count;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private boolean isPalindrome(Map<Integer, Integer> map) {
        int total = 0;
        int oddCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            total += entry.getValue();
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        if (total % 2 == 0) {
            return oddCount == 0;
        }
        return oddCount == 1;
    }

}
