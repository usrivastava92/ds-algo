package com.leet.daysofcode.year2020.april.week2;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {


    public static void main(String[] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int[] arr = {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(contiguousArray.findMaxLength(arr));
    }

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                int temp = i - map.get(sum);
                if (maxLen < temp) {
                    maxLen = temp;
                }
            } else {
                map.put(sum, i);
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

}
