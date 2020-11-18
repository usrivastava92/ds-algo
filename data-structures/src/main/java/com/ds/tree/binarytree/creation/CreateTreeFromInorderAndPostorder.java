package com.ds.tree.binarytree.creation;

import com.ds.tree.BinaryTreeNode;

import java.util.List;

public class CreateTreeFromInorderAndPostorder {

    private static int postIndex = 0;

    public static <T extends Comparable<T>> BinaryTreeNode<T> create(List<T> inorder, List<T> postorder) {
        postIndex = postorder.size() - 1;
        return createNode(inorder, postorder, 0, postIndex);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> createNode(final List<T> inorder, final List<T> postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(postorder.get(postIndex--));
        if (start == end) {
            return root;
        }
        int search = search(inorder, root.val, start, end);
        root.setLeft(createNode(inorder, postorder, 0, search - 1));
        root.setRight(createNode(inorder, postorder, search + 1, end));
        return root;
    }

    private static <T extends Comparable<T>> int search(List<T> list, T value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

}
