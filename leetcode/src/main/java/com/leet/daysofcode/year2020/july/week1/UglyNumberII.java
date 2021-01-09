package com.leet.daysofcode.year2020.july.week1;

import java.util.Arrays;

public class UglyNumberII {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] outputs = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15};
        UglyNumberII uglyNumberII = new UglyNumberII();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + uglyNumberII.nthUglyNumber(inputs[i]));
            System.out.println("Excepted : " + outputs[i]);
        }
    }

    public int nthUglyNumber(int n) {
        int[] firstNUgly = new int[n];
        firstNUgly[0] = 1;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        int i = 1;
        int j = 1;
        int k = 1;
        for (int index = 1; index < n; index++) {
            System.out.println(String.format("factor2->%s factor3->%s factor5->%s", factor2, factor3, factor5));
            firstNUgly[index] = Math.min(Math.min(factor2, factor3), factor5);
            if (firstNUgly[index] == factor2) {
                factor2 = firstNUgly[i++] * 2;
            }
            if (firstNUgly[index] == factor3) {
                factor3 = firstNUgly[j++] * 3;
            }
            if (firstNUgly[index] == factor5) {
                factor5 = firstNUgly[k++] * 5;
            }
            System.out.println(Arrays.toString(firstNUgly));
        }
        return firstNUgly[n - 1];
    }

}
