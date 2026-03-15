package com.ib.arrays;

import java.util.TreeSet;

public class MaximumSumTriplet {

  public int solve(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int[] rightMaxes = new int[A.length];
    int runningMax = A[A.length - 1];
    for (int i = A.length - 1; i > -1; i--) {
      runningMax = Math.max(runningMax, A[i]);
      rightMaxes[i] = runningMax;
    }
    int maxSum = Integer.MIN_VALUE;
    TreeSet<Integer> treeSet = new TreeSet<>();
    treeSet.add(A[0]);
    for (int i = 1; i < A.length - 1; i++) {
      int element = A[i];
      Integer lower = treeSet.lower(element);
      treeSet.add(A[i]);
      if (lower != null && element < rightMaxes[i + 1]) {
        maxSum = Math.max(lower + element + rightMaxes[i + 1], maxSum);
      }
    }
    return maxSum;
  }
}
