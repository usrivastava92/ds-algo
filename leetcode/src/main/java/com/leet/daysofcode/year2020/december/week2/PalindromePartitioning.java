package com.leet.daysofcode.year2020.december.week2;

import com.ds.utils.ArrayUtils;

import java.util.*;
import java.util.stream.IntStream;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String[] inputs = {"aab", "a", "bb", "bcdaab"};
        String[][][] outputs = {{{"a", "a", "b"}, {"aa", "b"}}, {{"a"}}, {{"bb"}, {"b", "b"}}, {{"b", "c", "d", "a", "a", "b"}, {"b", "c", "d", "aa", "b"}}};
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            List<List<String>> output = palindromePartitioning.partition(inputs[i]);
            System.out.println("Output : " + output);
            assert ArrayUtils.deepAsList(outputs[i]).equals(output);
        });
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }


}
