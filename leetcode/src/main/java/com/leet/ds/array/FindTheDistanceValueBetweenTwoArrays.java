package com.leet.ds.array;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {

    public static void main(String[] args) {
        int[][] arr1s = {{4, 5, 8}, {1, 4, 2, 3}, {2, 1, 100, 3}};
        int[][] arr2s = {{10, 9, 1, 8}, {-4, -3, 6, 10, 20, 30}, {-5, -2, 10, -3, 7}};
        int[] ds = {2, 3, 6};

        FindTheDistanceValueBetweenTwoArrays findTheDistanceValueBetweenTwoArrays = new FindTheDistanceValueBetweenTwoArrays();

        for (int i =0; i < ds.length; i++) {
            System.out.println("TestCase " + (i + 1) + " -> " + findTheDistanceValueBetweenTwoArrays.findTheDistanceValue(arr1s[i], arr2s[i], ds[i]));
        }
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int element : arr1) {
            int minDist = getMinDist(arr2, element);
            System.out.println(element+" -> "+minDist);
            if (minDist > d) {
                count++;
            }
        }
        return count;
    }

    private int getMinDist(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == element) {
                return 0;
            }
            if (mid == low) {
                return Math.min(Math.abs(arr[low] - element), Math.abs(arr[high] - element));
            }
            if (element > arr[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return Integer.MAX_VALUE;
    }

}
