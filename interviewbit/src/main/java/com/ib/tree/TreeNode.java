package com.ib.tree;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class TreeNode {

    @NonNull
    public int val;
    @ToString.Exclude
    public TreeNode left;
    @ToString.Exclude
    public TreeNode right;

}
