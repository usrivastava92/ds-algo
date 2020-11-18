package com.leet.ds.array;


import com.ds.utils.SortingUtils;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        int[][] inputs = {{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}};
        SortIntegersByTheNumberOf1Bits sortIntegersByTheNumberOf1Bits = new SortIntegersByTheNumberOf1Bits();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + Arrays.toString(sortIntegersByTheNumberOf1Bits.sortByBits(inputs[i])));
            System.out.println("#########################################");
        }
    }

    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        /*SortingUtils.quickSort(boxed, (i, j) -> {
            int comp = Integer.compare(Integer.bitCount(i), Integer.bitCount(j));
            if (comp == 0) {
                return Integer.compare(i, j);
            }
            return comp;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }*/
        return arr;
    }
}
