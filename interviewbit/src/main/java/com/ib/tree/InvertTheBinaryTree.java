package com.ib.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertTheBinaryTree {

    public TreeNode invertTree(TreeNode A) {
        if(A!=null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(A);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return A;
    }
}
