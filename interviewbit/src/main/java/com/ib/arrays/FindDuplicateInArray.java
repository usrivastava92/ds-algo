package com.ib.arrays;

public class FindDuplicateInArray {

    public int repeatedNumber(final int[] arr) {
        for (int i : arr) {
            if (i < 0) {
                i = i * -1;
            }
            if (arr[i - 1] < 0) {
                return i;
            } else {
                arr[i - 1] = -1 * arr[i - 1];
            }
        }
        return -1;
    }
}
