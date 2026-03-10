package com.ib.twopointers;

import java.util.Arrays;

public class PairWithGivenDifference {

    public int solve(int[] A, int B) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int len = A.length;
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        while (i < len && j < len) {
            if (i != j && A[j] - A[i] == B) {
                return 1;
            } else if (A[j] - A[i] < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }


}
