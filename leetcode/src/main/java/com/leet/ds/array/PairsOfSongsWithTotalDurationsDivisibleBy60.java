package com.leet.ds.array;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 pairsOfSongsWithTotalDurationsDivisibleBy60 = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println(pairsOfSongsWithTotalDurationsDivisibleBy60.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : time) {
            int remainder = a % 60;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        int ans = getNc2(map.getOrDefault(0, 0)) + getNc2(map.getOrDefault(30, 0));
        for (int i = 1; i < 30; i++) {
            int remaining = 60 - i;
            ans += (map.getOrDefault(i, 0) * map.getOrDefault(remaining, 0));
        }
        return ans;
    }

    public int getNc2(int n) {
        if (n < 2) {
            return 0;
        }
        return (n * (n - 1)) / 2;
    }

}
