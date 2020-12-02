package com.ib.arrays;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class MaxDistance {

    public static void main(String[] args) {
        int[] A = {3, 5, 4, 2};
        int output = 2;
        MaxDistance maxDistance = new MaxDistance();
        Assert.assertEquals(output, maxDistance.maximumGap(A));
    }

    public int maximumGap(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Integer[] indexArr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indexArr[i] = i;
        }
        Arrays.sort(indexArr, Comparator.comparingInt(i -> A[i]));
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(indexArr));
        int currMin = indexArr[0];
        int maxDiff = 0;
        for (int i = 0; i < A.length; i++) {
            if (indexArr[i] > currMin) {
                maxDiff = Math.max(maxDiff, Math.abs(indexArr[i] - currMin));
            }
            currMin = Math.min(currMin, indexArr[i]);
        }
        return maxDiff;
    }

}
