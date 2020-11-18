package com.misc;

import java.util.Arrays;

class CountFrequencies {
    private static int[] findCounts(int arr[], int n) {
        int i = 0;
        while (i < n) {
            int element = arr[i];
            if (element <= 0) {
                i++;
                continue;
            }
            int elementIndex = element - 1;
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];
                arr[elementIndex] = -1;
            } else {
                arr[elementIndex]--;
                arr[i] = 0;
                i++;
            }
        }
        return arr;
    }

    private static int[] printfrequency(int arr[], int n) {
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < n; j++) {
            arr[j] = arr[j] - 1;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int x = arr[i] % n;
            System.out.println("arr[" + x + "] = " + "arr[" + x + "] + " + n);
            arr[x] = arr[x] + n;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5};
        System.out.println(Arrays.toString(findCounts(arr.clone(), arr.length)));
        System.out.println(Arrays.toString(printfrequency(arr.clone(), arr.length)));

    }
}