package com.ib.twopointers;

public class ContainerWithMostWater {

  public int maxArea(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int i = 0;
    int j = A.length - 1;
    int max = 0;
    while (i < j) {
      int curr = Math.min(A[i], A[j]) * (j - i);
      max = Math.max(max, curr);
      if (A[i] < A[j]) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }
}
