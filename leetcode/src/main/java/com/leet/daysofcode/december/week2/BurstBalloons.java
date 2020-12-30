package com.leet.daysofcode.december.week2;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

public class BurstBalloons {

    public static void main(String[] args) {
        int[][] inputs = {{3, 1, 0, 5, 0, 8}, {3, 1, 5, 8}, {35, 16, 83, 87, 84, 59, 48, 41}, {1, 6, 8, 3, 4, 6, 4, 7, 9, 8, 0, 6, 2, 8}, {2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3}, {8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2, 9}};
        int[] outputs = {167, 167, 1583373, 3376, 2925, 4141};
        BurstBalloons burstBalloons = new BurstBalloons();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = burstBalloons.maxCoins(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) {
            if (x > 0) {
                nums[n++] = x;
            }
        }
        nums[0] = nums[n++] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int maxCoinsI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : nums) {
            linkedList.add(num);
        }
        for (int i = 0; i < linkedList.size(); ) {
            if (linkedList.get(i) == 0) {
                linkedList.remove(i);
            } else {
                i++;
            }
        }
        return helper(linkedList, new HashMap<>());
    }

    public int helper(LinkedList<Integer> linkedList, Map<String, Integer> dp) {
        if (linkedList.isEmpty()) {
            return 0;
        }
        String key = linkedList.toString();
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int max = 0;
        for (int i = 0, len = linkedList.size(); i < len; i++) {
            Integer element = linkedList.get(i);
            int curr = linkedList.get(i) * (i - 1 > -1 ? linkedList.get(i - 1) : 1) * (i + 1 < linkedList.size() ? linkedList.get(i + 1) : 1);
            linkedList.remove(i);
            max = Math.max(max, curr + helper(linkedList, dp));
            linkedList.add(i, element);
        }
        dp.put(key, max);
        return max;
    }

}
