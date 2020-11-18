package com.leet.ds.codeforces;

import com.ds.tree.TreeNode;
import com.ds.utils.TreeUtils;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = com.ds.utils.TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(treeNode);
    }

}
