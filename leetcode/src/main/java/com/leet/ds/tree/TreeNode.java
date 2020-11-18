package com.leet.ds.tree;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class TreeNode {

    @NonNull
    public int val;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public TreeNode left;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public TreeNode right;

}
