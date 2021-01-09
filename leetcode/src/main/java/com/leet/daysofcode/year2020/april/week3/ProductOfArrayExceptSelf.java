package com.leet.daysofcode.year2020.april.week3;

import java.util.Arrays;

class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int allProd = 1;
        int numberOfZeros = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) {
                numberOfZeros++;
            } else {
                allProd *= nums[i];
            }
        }
        int[] ans = new int[nums.length];
        if (numberOfZeros == 1) {
            for (int i = 0, len = nums.length; i < len; i++) {
                if (nums[i] == 0) {
                    ans[i] = allProd;
                } else {
                    ans[i] = 0;
                }
            }
        } else if (numberOfZeros == 0) {
            for (int i = 0, len = nums.length; i < len; i++) {
                ans[i] = allProd / nums[i];
            }
        }
        return ans;
    }
}