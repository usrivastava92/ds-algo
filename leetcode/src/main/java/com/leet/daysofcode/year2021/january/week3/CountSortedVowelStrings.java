package com.leet.daysofcode.year2021.january.week3;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 5, 33, 50};
        int[] outputs = {5, 15, 35, 126, 66045, 316251};
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            int output = countSortedVowelStrings.countVowelStrings(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int countVowelStrings(int n) {
        if (n == 0) {
            return 0;
        }
        return solve(n, 1, new HashMap<>());
    }

    private int solve(final int n, int last, Map<String, Integer> dp) {
        if (n <= 0) {
            return 0;
        }
        String key = getKey(n, last);
        if (dp.containsKey(key)) {
            System.out.println(key);
            return dp.get(key);
        }
        if (n == 1) {
            return 6 - last;
        }
        int ans = 0;
        for (int j = last; j <= 5; j++) {
            ans += solve(n - 1, j, dp);
        }
        dp.put(key, ans);
        return ans;
    }

    private String getKey(int a, int b) {
        return a + "," + b;
    }

}
