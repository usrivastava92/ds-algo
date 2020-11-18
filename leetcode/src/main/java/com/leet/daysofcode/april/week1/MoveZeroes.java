package com.leet.daysofcode.april.week1;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for (int i : nums) {
            if (i != 0) {
                nonZero++;
            }
        }
        System.out.println(nonZero);
        int n = nums.length;
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                System.out.println("i -> " + nonZeroIndex + " : " + nums[nonZeroIndex] + " -> " + nums[i]);
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
            if (nonZeroIndex > nonZero) {
                break;
            }
        }
        while (nonZeroIndex < n) {
            nums[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
