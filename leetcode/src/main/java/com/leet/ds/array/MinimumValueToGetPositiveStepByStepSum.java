package com.leet.ds.array;

public class MinimumValueToGetPositiveStepByStepSum {

    public static void main(String[] args) {
        MinimumValueToGetPositiveStepByStepSum minimumValueToGetPositiveStepByStepSum = new MinimumValueToGetPositiveStepByStepSum();
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        System.out.println(minimumValueToGetPositiveStepByStepSum.minStartValue(nums));
    }


    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int a : nums) {
            sum += a;
            if (sum < min) {
                min = sum;
            }
        }
        if (min > 0) {
            return 1;
        }
        return 1-min;
    }

}
