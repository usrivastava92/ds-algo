package com.ib.tree;

public class SortedArrayToBalancedBST {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SortedArrayToBalancedBST sortedArrayToBalancedBST = new SortedArrayToBalancedBST();
        System.out.println(sortedArrayToBalancedBST.createBalancedTree(arr));
    }

    private TreeNode createBalancedTree(int[] arr) {
        return createNode(arr, 0, arr.length - 1);
    }

    private TreeNode createNode(final int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode returnNode = new TreeNode(arr[mid]);
        returnNode.left = createNode(arr, low, mid - 1);
        returnNode.right = createNode(arr, mid + 1, high);
        return returnNode;
    }


}
