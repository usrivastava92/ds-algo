package com.gfg.arrays;

class RotateArray {

  public static void rotate(int[] arr, int k, int size) {
    for (int i = 0, len = gcd(k, size); i < len; i++) {
      int temp = arr[i];
      int curr = i;
      while (true) {
        int next = curr + k;
        if (next >= size) {
          next -= size;
        }
        if (next == i) {
          break;
        }
        arr[curr] = arr[next];
        curr = next;
      }
      arr[curr] = temp;
    }
  }

  public static int gcd(int i, int j) {
    if (j == 0) {
      return i;
    }
    return gcd(j, i % j);
  }
}
