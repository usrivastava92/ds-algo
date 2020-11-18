package com.ds.tree.binarytree.creation;

import com.ds.tree.BinaryTreeNode;

import java.util.List;

public class CreateTreeFromInorderAndPreorder {

    private static int preIndex = 0;

    public static <T extends Comparable<T>> BinaryTreeNode<T> create(List<T> inorder, List<T> preorder) {
        preIndex = 0;
        return createNode(inorder, preorder, 0, preorder.size() - 1);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> createNode(final List<T> inorder, final List<T> preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(preorder.get(preIndex++));
        if (start == end) {
            return root;
        }
        int search = searchItem(inorder, start, end, root.val);
        root.setLeft(createNode(inorder, preorder, start, search - 1));
        root.setRight(createNode(inorder, preorder, search + 1, end));
        return root;
    }

    private static <T extends Comparable<T>> int searchItem(List<T> inorder, int start, int end, T item) {
        for (int i = start; i <= end; i++) {
            if (inorder.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }


}
