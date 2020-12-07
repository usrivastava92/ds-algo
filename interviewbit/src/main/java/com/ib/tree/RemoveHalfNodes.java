package com.ib.tree;

public class RemoveHalfNodes {

    public static void main(String[] args) {
        RemoveHalfNodes removeHalfNodes = new RemoveHalfNodes();
        TreeNode treeNode = TreeUtils.createTreeFromBfsArray(29, 10, 15, 28, 28, 29, 4, 4, null, null, null, null, null, null, null, null, null);
        TreeUtils.prettyPrintTree(treeNode);
        removeHalfNodes.solve(treeNode);
        System.out.println("##############################################");
        TreeUtils.prettyPrintTree(treeNode);
    }

    public TreeNode solve(TreeNode A) {
        if (A == null) {
            return null;
        }
        if (isHalf(A)) {
            return A.left != null ? solve(A.left) : solve(A.right);
        }
        A.left = solve(A.left);
        A.right = solve(A.right);
        return A;
    }

    private boolean isHalf(TreeNode node) {
        return node != null && (node.left == null || node.right == null) && !isLeaf(node);
    }

    private boolean isLeaf(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }

}
