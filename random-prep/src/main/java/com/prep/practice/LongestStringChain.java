package com.prep.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LongestStringChain {

    public static void main(String[] args) {
        String[][] inputs = {{"a", "b", "ba", "bca", "bda", "bdca"}};
        int[] outputs = {4};
        LongestStringChain longestStringChain = new LongestStringChain();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + longestStringChain.longestStrChain(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

}
