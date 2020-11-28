package com.ib.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinJumpsArray {

    public static void main(String[] args) {
        MinJumpsArray minJumpsArray = new MinJumpsArray();
        System.out.println(minJumpsArray.jump(new ArrayList<>(Arrays.asList(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28))));
    }

    public int jump(ArrayList<Integer> maxJumps) {
        if (maxJumps.size() <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int target = maxJumps.size() - 1;
        for (int i = target - 1; i > -1; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = maxJumps.get(i); j >= 1; j--) {
                int sum = i + j;
                if (sum >= target) {
                    min = 1;
                    break;
                } else {
                    Integer val = map.get(sum);
                    if (val != -1) {
                        if (min > 1 + val) {
                            min = 1 + val;
                        }
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            map.put(i, min);
            System.out.println(map);
        }
        return map.get(0);
    }


}
