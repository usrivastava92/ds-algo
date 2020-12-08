package com.ib.dp;

import com.ib.tree.TreeNode;
import com.ib.tree.TreeUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

public class MaxSumPathInBinaryTree {

    public static void main(String[] args) {
        TreeNode[] inputs = {TreeUtils.createTreeFromBfsArray(-200, -100, null, -300, -400, null, null, null, null)};
        int[] outputs = {-100};
        MaxSumPathInBinaryTree maxSumPathInBinaryTree = new MaxSumPathInBinaryTree();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(inputs[i]);
            int output = maxSumPathInBinaryTree.maxPathSum(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(output, outputs[i]);
        });
    }

    public int maxPathSum(TreeNode A) {
        Int max = new Int();
        return Math.max(maxPathSum(A, max), max.num);
    }

    public int maxPathSum(TreeNode A, Int max) {
        if (A == null) {
            return 0;
        }
        int left = maxPathSum(A.left, max);
        int right = maxPathSum(A.right, max);
        max.num = Math.max(max.num, left + right + A.val);
        max.num = Math.max(max.num, A.val);
        return A.val + Math.max(left, right);
    }

    private static final class Int {
        int num = Integer.MIN_VALUE;
    }

}
