package com.leet.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {


    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.createBst(2, 1, 4);
        TreeNode root2 = TreeUtils.createBst(1, 0, 3);

        AllElementsInTwoBinarySearchTrees allElementsInTwoBinarySearchTrees = new AllElementsInTwoBinarySearchTrees();
        System.out.println(allElementsInTwoBinarySearchTrees.getAllElements(root1, root2));


    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list = new ArrayList<>();
        TreeIterators.InorderIterator inorderIterator1 = new TreeIterators.InorderIterator(root1);
        TreeIterators.InorderIterator inorderIterator2 = new TreeIterators.InorderIterator(root2);

        while (inorderIterator1.hasNext() && inorderIterator2.hasNext()) {
            if (inorderIterator1.peekNext().val < inorderIterator2.peekNext().val) {
                list.add(inorderIterator1.next().val);
            } else {
                list.add(inorderIterator2.next().val);
            }
        }

        while (inorderIterator1.hasNext()) {
            list.add(inorderIterator1.next().val);
        }

        while (inorderIterator2.hasNext()) {
            list.add(inorderIterator2.next().val);
        }

        return list;
    }

}
