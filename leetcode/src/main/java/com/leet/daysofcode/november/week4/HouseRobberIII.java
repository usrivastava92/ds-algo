package com.leet.daysofcode.november.week4;

import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;

import java.util.stream.IntStream;

public class HouseRobberIII {

    public static void main(String[] args) {
        TreeNode[] inputs = {TreeUtils.createTreeFromBfsArray(3, 2, 3, null, 3, null, 1), TreeUtils.createTreeFromBfsArray(3, 4, 5, 1, 3, null, 1)};
        int[] outputs = {7, 9};
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeUtils.prettyPrintTree(inputs[i]);
            System.out.println("Output : " + houseRobberIII.rob(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    private int rob(TreeNode input) {
        return 1;
    }


}
