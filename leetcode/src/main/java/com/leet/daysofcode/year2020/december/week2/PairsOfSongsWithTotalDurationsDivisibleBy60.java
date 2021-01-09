package com.leet.daysofcode.year2020.december.week2;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {

    }

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : time) {
            int remainder = i % 60;
            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }
        int count = getNc2(countMap.getOrDefault(0, 0)) + getNc2(countMap.getOrDefault(30, 0));
        for (int i = 1; i < 30; i++) {
            int b = 60 - i;
            int pairs = countMap.getOrDefault(i, 0) * countMap.getOrDefault(b, 0);
            count += pairs;
        }
        return count;
    }

    private int getNc2(int n) {
        if (n < 2) {
            return 0;
        }
        int a = n;
        int b = n - 1;
        if (a % 2 == 0) {
            return (a / 2) * b;
        }
        return a * (b / 2);
    }


}
