package com.ds.tree;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
public class TreeNode<T extends Comparable<T>> {

    public T val;
    @ToString.Exclude
    private final List<TreeNode<T>> children;

    public TreeNode(T val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        if (Objects.nonNull(child)) {
            this.children.add(child);
        }
    }

    public void removeChild(TreeNode<T> child) {
        if (Objects.nonNull(child)) {
            this.children.remove(child);
        }
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

}
