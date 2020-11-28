package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static void main(String... arsgs) {
        ThreeSum threeSum = new ThreeSum();
        int b = 1;
        System.out.println(threeSum.threeSumClosest(new ArrayList<>(Arrays.asList(2, 1, -4, -1)), b));
    }

    public int threeSumClosest(ArrayList<Integer> A, int b) {
        Collections.sort(A);
        System.out.println(A);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 2; i++) {
            int j = i + 1;
            int k = A.size() - 1;
            while (j < k) {
                System.out.println(A.get(i)+" " + A.get(j) +" "+ A.get(k));
                int sum = A.get(i) + A.get(j) + A.get(k);
                int diff = Math.abs(sum - b);
                if (diff == 0) {
                    return b;
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if (sum <= b) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
