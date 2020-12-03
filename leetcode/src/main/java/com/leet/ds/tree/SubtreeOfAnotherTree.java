package com.leet.ds.tree;

import java.util.stream.IntStream;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode[] s = {TreeUtils.createTreeFromBfsArray(3, 4, 5, 1, 2), TreeUtils.createTreeFromBfsArray(3, 4, 5, 1, 2, null, null, null, null, 0), TreeUtils.createTreeFromBfsArray(1, 2, 3)};
        TreeNode[] t = {TreeUtils.createTreeFromBfsArray(4, 1, 2), TreeUtils.createTreeFromBfsArray(4, 1, 2), TreeUtils.createTreeFromBfsArray(1, 2)};
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        IntStream.range(0, s.length).forEachOrdered(i -> {
            System.out.println("S : ");
            TreeUtils.prettyPrintTree(s[i]);
            System.out.println("T : ");
            TreeUtils.prettyPrintTree(t[i]);
            System.out.println("Output : " + subtreeOfAnotherTree.isSubtree(s[i], t[i]));
        });
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.right, node2.right) && isSame(node1.left, node2.left);
    }


}
