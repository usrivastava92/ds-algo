package com.leet.daysofcode.april.week4;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 1};
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(arr, 0));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(sum, 1);
        for (int num : nums) {
            sum += num;
            System.out.println(map + " : " + (sum - k));
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
