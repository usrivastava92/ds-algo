package com.ib.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBt {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> traversal = new ArrayList<>();
        if (A != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode temp = queue.poll();
                    tempList.add(temp.val);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                if (level % 2 == 0) {
                    reverseList(tempList);
                }
                traversal.add(tempList);
            }
        }
        return traversal;
    }


    public void reverseList(ArrayList<Integer> arr) {
        int size = arr.size();
        for (int i = 0, len = size / 2, j = size - 1; i < len; i++, j--) {
            Integer temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }
}
