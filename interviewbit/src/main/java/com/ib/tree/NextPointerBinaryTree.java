package com.ib.tree;

public class NextPointerBinaryTree {

    public void connect(TreeLinkNode root) {
        helper(root, null);
    }

    private void helper(TreeLinkNode root, TreeLinkNode parent){
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (parent != null) {
            TreeLinkNode curr = parent.next;
            while (curr != null && root.next == null) {
                if (curr.left != null || curr.right != null) {
                    root.next = curr.left != null ? curr.left : curr.right;
                    break;
                }
                curr = curr.next;
            }
        }
        helper(root.right, root);
        helper(root.left, root);
    }

}
