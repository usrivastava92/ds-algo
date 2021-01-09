package com.leet.daysofcode.year2020.april.week1;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }
}
