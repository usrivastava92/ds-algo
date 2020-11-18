package com.ib.arrays;

import java.util.*;

public class MaximumConsecutiveGap {

    public static void main(String... args) {
        MaximumConsecutiveGap maxConsecutiveGap = new MaximumConsecutiveGap();
        System.out.println(maxConsecutiveGap.maximumGap(Arrays.asList(1, 10, 5)));
    }

    public int maximumGap(final List<Integer> A) {
        if (A.size() < 2) return 0;
        TreeSet<Integer> set = new TreeSet<>(A);
        int i = 0;
        int prev = -1;
        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (i == 0) {
                prev = num;
                i = 1;
            } else {
                max = Math.max(max, num - prev);
                prev = num;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

}
