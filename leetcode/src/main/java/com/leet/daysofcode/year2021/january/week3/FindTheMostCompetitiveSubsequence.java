package com.leet.daysofcode.year2021.january.week3;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindTheMostCompetitiveSubsequence {

    public static void main(String[] args) {
        int[][] nums = {{3, 5, 2, 6}, {2, 4, 3, 3, 5, 4, 9, 6}, {71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}};
        int[] k = {2, 4, 3};
        int[][] outputs = {{2, 6}, {2, 3, 3, 4}, {8, 80, 2}};
        FindTheMostCompetitiveSubsequence competitiveSubsequence = new FindTheMostCompetitiveSubsequence();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(nums[i]) + " k : " + k[i]);
            int[] output = competitiveSubsequence.mostCompetitive(nums[i], k[i]);
            System.out.println("Output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[][] ans = new int[1][];
        boolean[] flowFromBack = new boolean[1];
        flowFromBack[0] = true;
        helper(new int[k], 0, 0, ans, nums, flowFromBack);
        return ans[0];
    }

    private void helper(int[] comb, int start, int index, int[][] ans, int[] nums, boolean[] flowFromBack) {
        if (index >= comb.length) {
            System.out.println(Arrays.toString(comb));
            compare(ans, comb);
            flowFromBack[0] = false;
            return;
        }
        int len = nums.length;
        for (int i = start; i <= len - (comb.length - index); i++) {
            if (flowFromBack[0] || ans[0] == null || nums[i] <= ans[0][index]) {
                flowFromBack[0] = true;
                comb[index] = nums[i];
                helper(comb, i + 1, index + 1, ans, nums, flowFromBack);
            }
        }
    }

    private void compare(int[][] ans, int[] b) {
        if (ans[0] == null) {
            ans[0] = Arrays.copyOf(b, b.length);
            return;
        }
        int[] a = ans[0];
        int len = b.length;
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                if (a[i] < b[i]) {
                    return;
                }
                ans[0] = Arrays.copyOf(b, b.length);
                return;
            }
        }
    }

}
