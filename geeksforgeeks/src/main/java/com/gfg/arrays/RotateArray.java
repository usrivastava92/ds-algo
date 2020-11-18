package com.gfg.arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            k = k % size;
            rotate(arr, k, size);
            System.out.println(Arrays.toString(arr).replaceAll("[,]", "").replace("[", "").replace("]", ""));
        }
        sc.close();
    }

    public static void rotate(int[] arr, int k, int size) {
        for (int i = 0, len = gcd(k, size); i < len; i++) {
            int temp = arr[i];
            int curr = i;
            while (true) {
                int next = curr + k;
                if (next >= size) {
                    next = next - size;
                }
                if (next == i) {
                    break;
                }
                arr[curr] = arr[next];
                curr = next;
            }
            arr[curr] = temp;
        }
    }

    public static int gcd(int i, int j) {
        if (j == 0) {
            return i;
        }
        return gcd(j, i % j);
    }
}
