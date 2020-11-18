package com.ib.arrays;

public class FindDuplicateInArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 4, 1};
        FindDuplicateInArray findDuplicateInArray = new FindDuplicateInArray();
        System.out.println(findDuplicateInArray.repeatedNumber(arr));
    }

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
