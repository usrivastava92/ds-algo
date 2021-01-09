package com.leet.daysofcode.year2020.november.week1;

import java.util.stream.IntStream;

public class ConsecutiveCharacters {

    public static void main(String[] args) {
        String[] inputs = {"leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist", "", "i"};
        int[] outputs = {2, 5, 5, 11, 1, 0, 1};
        ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("output : " + consecutiveCharacters.maxPower(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxPower(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int max = 1;
        char prev = s.charAt(0);
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                len++;
            } else {
                len = 1;
                prev = s.charAt(i);
            }
            max = Math.max(max, len);
        }
        return max;
    }

}
