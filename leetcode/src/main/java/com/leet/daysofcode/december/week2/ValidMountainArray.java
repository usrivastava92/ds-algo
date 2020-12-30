package com.leet.daysofcode.december.week2;

public class ValidMountainArray {

    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int i = 1;
        int prev = arr[0];
        int len = arr.length;
        while (i < len && arr[i] > prev) {
            prev = arr[i];
            i++;
        }
        if (i == len || i == 1) {
            return false;
        }
        while (i < len && arr[i] < prev) {
            prev = arr[i];
            i++;
        }
        return i == len;
    }

}
