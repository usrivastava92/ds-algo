package com.misc;

import com.ib.tree.TreeNode;
import com.ib.tree.TreeUtils;

public class Executor {
    public static void main(String... args) {
        TreeNode node = TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(node);
    }
}