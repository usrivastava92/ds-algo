package com.ib.arrays;

public class NextPermutation {

    public int[] nextPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int len = A.length;
        for (int i = len - 2; i > -1; i--) {
            if (A[i] < A[i + 1]) {
                int temp = i + 1;
                while (temp + 1 < len && A[temp + 1] > A[i]) {
                    temp++;
                }
                swap(A, i, temp);
                reverse(A, i + 1, A.length - 1);
                return A;
            }
        }
        reverse(A, 0, A.length - 1);
        return A;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
