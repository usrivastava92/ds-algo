package com.ib.arrays;

import org.junit.Assert;

import java.util.*;

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
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> indexes = indexMap.getOrDefault(A[i], new ArrayList<>());
            indexMap.put(A[i], indexes);
        }
        return 1;
    }

}
