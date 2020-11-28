package com.ib.tree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInTree {


    public int kthsmallest(TreeNode A, int B) {
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        if(A!=null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                priority.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        int ans = -1;
        while(B-- > 0){
            ans= priority.remove();
        }
        return ans;
    }
}
