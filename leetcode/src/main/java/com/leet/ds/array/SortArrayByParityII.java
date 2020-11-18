package com.leet.ds.array;

import java.util.Arrays;

public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(arr)));
    }

    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int i = 0;
        int odd = 1;
        while (i < A.length && odd < A.length) {
            if (A[i] % 2 != 0) {
                swap(A, odd, i);
                odd += 2;
            } else {
                i += 2;
            }
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
