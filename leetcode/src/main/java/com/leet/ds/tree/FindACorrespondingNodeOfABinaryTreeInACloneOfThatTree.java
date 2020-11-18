package com.leet.ds.tree;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public static void main(String[] args) {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || target == null || cloned == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode searchLeft = getTargetCopy(original.left, cloned.left, target);
        TreeNode searchRight = getTargetCopy(original.right, cloned.right, target);

        return searchLeft == null ? searchRight : searchLeft;
    }

}
