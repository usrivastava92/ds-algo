package com.ib.arrays;

public class MaximumUnsortedSubarray {

    public int[] subUnsort(int[] A) {
        int len = A.length;
        int[] min = new int[len];
        int[] max = new int[len];
        int currMax = A[0];
        for (int i = 0; i < len; i++) {
            currMax = Math.max(currMax, A[i]);
            max[i] = currMax;
        }
        int currMin = A[len - 1];
        for (int i = len - 1; i > -1; i--) {
            currMin = Math.min(currMin, A[i]);
            min[i] = currMin;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (min[i] != max[i]) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        if (start == -1) {
            return new int[]{-1};
        }
        return new int[]{start, end};
    }

}
