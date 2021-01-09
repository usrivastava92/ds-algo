package com.leet.daysofcode.year2020.june.week1;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    public static void main(String[] args) {
        int[][] inputs = {{1}, {1, 3}};
        int[][] outputs = {{0}, {0, 1, 1, 1, 0}};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            Solution solution = new Solution(inputs[i]);
            int[] output = new int[outputs[i].length];
            for (int j = 0; j < outputs[i].length; j++) {
                output[j] = solution.pickIndex();
            }
            System.out.println("Output : " + Arrays.toString(output));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
            System.out.println("##################################");
        }
    }

    private static class Solution {

        private Random random;
        private int[] wSums;

        public Solution(int[] w) {
            this.random = new Random();
            for (int i = 1; i < w.length; ++i)
                w[i] += w[i - 1];
            this.wSums = w;
        }

        public int pickIndex() {
            int len = wSums.length;
            int idx = random.nextInt(wSums[len - 1]) + 1;
            int left = 0, right = len - 1;
            // search position
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (wSums[mid] == idx)
                    return mid;
                else if (wSums[mid] < idx)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }
}

