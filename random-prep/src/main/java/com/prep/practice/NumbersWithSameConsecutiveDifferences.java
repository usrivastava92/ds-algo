package com.prep.practice;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {
        int[] ns = {3, 2, 2, 2};
        int[] ks = {7, 1, 0, 2};
        int[][] outputs = {{181, 292, 707, 818, 929}, {10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98}, {11, 22, 33, 44, 55, 66, 77, 88, 99}, {13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97}};
        NumbersWithSameConsecutiveDifferences numbersWithSameConsecutiveDifferences = new NumbersWithSameConsecutiveDifferences();
        IntStream.range(0, ns.length).forEachOrdered(i -> {
            System.out.printf("Input : n -> %s , k -> %s\n", ns[i], ks[i]);
            int[] output = numbersWithSameConsecutiveDifferences.numsSameConsecDiff(ns[i], ks[i]);
            Arrays.sort(output);
            Arrays.sort(outputs[i]);
            System.out.println("Output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            generate(i, 1, n, k, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void generate(int num, int len, final int requiredLen, final int diff, List<Integer> list) {
        if (len >= requiredLen) {
            list.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit + diff < 10) {
            generate(num * 10 + (lastDigit + diff), len + 1, requiredLen, diff, list);
        }
        if (diff != 0 && lastDigit - diff > -1) {
            generate(num * 10 + (lastDigit - diff), len + 1, requiredLen, diff, list);
        }
    }

}
