package com.leet.daysofcode.may.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        int[][] inputs = {{0, 1}, {0, 1, 0},{0,0,0,1,0,1,0,1}};
        int[] outputs = {2, 2,6};
        ContiguousArray contiguousArray = new ContiguousArray();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + contiguousArray.findMaxLength(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        }
    }


    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                if (maxLen < len) {
                    maxLen = len;
                }
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
