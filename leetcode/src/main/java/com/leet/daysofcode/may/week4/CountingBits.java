package com.leet.daysofcode.may.week4;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        int[] nums = {5, 7, 2, 9, 3};
        CountingBits countingBits = new CountingBits();
        for (int num : nums) {
            System.out.println("Input : " + num);
            System.out.println("Output : " + Arrays.toString(countingBits.countBits(num)));
        }
    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                ans[i] = ans[i >> 1] + 1;
            } else {
                ans[i] = ans[i >> 1];
            }
        }
        return ans;
    }

}
