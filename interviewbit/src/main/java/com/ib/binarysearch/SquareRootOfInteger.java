package com.ib.binarysearch;

public class SquareRootOfInteger {

  public int sqrt(int A) {
    if (A == 1) {
      return 1;
    }
    return findBinarySqrt(1, A, A);
  }

  private int findBinarySqrt(int low, int high, int num) {

    int mid = (low + ((high - low) / 2));
    if (mid == low || mid == high) {
      return mid;
    }
    int div = num / mid;
    if (div == mid) {
      return mid;
    } else if (div > mid) {
      return findBinarySqrt(mid, high, num);
    } else {
      return findBinarySqrt(low, mid, num);
    }
  }
}
