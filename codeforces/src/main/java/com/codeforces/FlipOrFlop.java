package com.codeforces;

public class FlipOrFlop {

  /**
   * Find the minimum number of bit flip operations to make XOR of array equal to T.
   *
   * @param n Size of the array
   * @param A The integer array
   * @param T The target XOR value
   * @return Minimum number of operations (bit flips) required
   */
  public static int minOperations(int n, int[] A, int T) {
    // Calculate current XOR of all elements
    int currentXor = 0;
    for (int num : A) {
      currentXor ^= num;
    }

    // Find bits that need to be flipped
    // These are the bits that differ between currentXor and T
    int needToFlip = currentXor ^ T;

    // Count number of set bits (1s) in needToFlip
    // Each set bit represents one bit flip operation needed
    return Integer.bitCount(needToFlip);
  }

  public static void main(String[] args) {
    // Example 1: {3, 4}, T = 2
    int[] arr1 = {3, 4};
    int result1 = minOperations(2, arr1, 2);
    System.out.println("Example 1: " + result1); // Output: 2

    // Example 2: {1, 3, 2}, T = 0
    int[] arr2 = {1, 3, 2};
    int result2 = minOperations(3, arr2, 0);
    System.out.println("Example 2: " + result2); // Output: 0

    // Additional test cases
    int[] arr3 = {5, 6, 7};
    int result3 = minOperations(3, arr3, 15);
    System.out.println("Example 3: " + result3);

    int[] arr4 = {15};
    int result4 = minOperations(1, arr4, 0);
    System.out.println("Example 4: " + result4);
  }
}
