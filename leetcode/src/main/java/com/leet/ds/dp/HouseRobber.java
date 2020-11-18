package com.leet.ds.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HouseRobber {


    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 1}, {2, 7, 9, 3, 1}};
        int[] outputs = {4, 12};
        HouseRobber houseRobber = new HouseRobber();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + houseRobber.rob(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ifRobbedPrev = 0;
        int ifNotRobbedPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentRobbed = ifNotRobbedPrev + nums[i];
            int currentNotRobbed = Math.max(ifNotRobbedPrev, ifRobbedPrev);
            ifRobbedPrev = currentRobbed;
            ifNotRobbedPrev = currentNotRobbed;
        }
        return Math.max(ifNotRobbedPrev, ifRobbedPrev);
    }

}
