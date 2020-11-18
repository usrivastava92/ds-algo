package com.gfg.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ConvertArrayZigZagFashion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            makeZigZagModifiedBubbleSort(arr,size);
            System.out.println(Arrays.toString(arr));
            System.out.println(validateAns(arr));
        }
        sc.close();
    }

    public static void makeZigZagBySort(int[] arr, int size) {
        Arrays.sort(arr);
        for (int i = 1; i < size; i = i + 2) {
            if (i + 1 < size) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    public static void makeZigZagModifiedBubbleSort(int[] arr, int size) {
        boolean greater = false;
        for (int i = 0; i < size - 1; i++) {
            if (greater) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            greater = !greater;
        }
    }

    public static boolean validateAns(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i += 2) {
            int prev = i - 1;
            int next = i + 1;
            if (prev > -1) {
                if (arr[prev] > arr[i]) {
                    return false;
                }
            }
            if (next < size) {
                if (arr[next] > arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
