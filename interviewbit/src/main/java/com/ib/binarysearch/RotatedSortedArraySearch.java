package com.ib.binarysearch;

public class RotatedSortedArraySearch {

  public int search(final int[] A, int B) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int low = 0;
    int high = A.length - 1;
    int pivot = findPivot(A);
    if (B >= A[low] && B <= A[pivot]) {
      return binarySearch(A, low, pivot, B);
    }
    return binarySearch(A, pivot + 1, high, B);
  }

  private int findPivot(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    /*
    4, 5, 6, 7, 0, 1, 2, 3
    0  1  2  3  4  5  6  7
    0 7 3
    3 7 5
    3 5 4
    3 4 3
     */
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (mid == low) {
        break;
      }
      if (arr[mid] >= arr[low]) {
        low = mid;
      } else {
        high = mid;
      }
    }
    return low;
  }

  private int binarySearch(final int[] arr, int low, int high, final int target) {
    /*
    4, 5, 6, 7, 0, 1, 2, 3
    0  1  2  3  4  5  6  7
    0 3 1
    0 1 0
     */
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
