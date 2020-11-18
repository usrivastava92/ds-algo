package com.ds.tree;

import lombok.*;

@ToString
public class BinaryTreeNode<T extends Comparable<T>> extends TreeNode<T> {

    @ToString.Exclude
    private BinaryTreeNode<T> left;
    @ToString.Exclude
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(@NonNull T val) {
        super(val);
    }

    public void setLeft(BinaryTreeNode<T> left) {
        if (this.left != null) {
            super.removeChild(this.left);
        }
        super.addChild(left);
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        super.addChild(right);
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

}
