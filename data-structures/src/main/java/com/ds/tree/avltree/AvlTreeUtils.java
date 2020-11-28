package com.ds.tree.avltree;

import com.ds.tree.BinaryTreeNode;

public class AvlTreeUtils {

    public static <T extends Comparable<T>> BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> binaryTreeNode) {
        BinaryTreeNode<T> newRoot = binaryTreeNode.getLeft();
        BinaryTreeNode<T> newRootRight = binaryTreeNode;
        BinaryTreeNode<T> newRootRightLeft = newRoot.getRight();
        newRoot.setRight(newRootRight);
        newRootRight.setLeft(newRootRightLeft);
        return newRoot;
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> binaryTreeNode) {
        BinaryTreeNode<T> newRoot = binaryTreeNode.getRight();
        BinaryTreeNode<T> newRootLeftRight = newRoot.getLeft();
        newRoot.getLeft().setRight(newRootLeftRight);
        return newRoot;
    }
}
