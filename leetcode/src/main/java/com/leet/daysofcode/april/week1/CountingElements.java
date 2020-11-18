package com.leet.daysofcode.april.week1;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {


    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int temp = i + 1;
            if (map.containsKey(temp)) {
                ans += map.get(i) < map.get(temp) ? map.get(i) : map.get(temp);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2};
        CountingElements countingElements = new CountingElements();
        countingElements.countElements(arr);
    }
}
