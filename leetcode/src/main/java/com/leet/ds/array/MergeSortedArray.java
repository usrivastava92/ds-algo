package com.leet.ds.array;

import java.util.Arrays;

public class MergeSortedArray {


    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || n == 0 || nums2 == null) {
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        int index = nums1.length - 1;
        while (p1 > -1 && p2 > -1) {
            if (nums2[p2] > nums1[p1]) {
                nums1[index--] = nums2[p2--];
            } else {
                nums1[index--] = nums1[p1--];
            }
        }
        System.out.println(p1+" : "+p2);
        while (p1 > -1) {
            nums1[index--] = nums1[p1--];
        }
        while (p2 > -1) {
            nums1[index--] = nums2[p2--];
        }
    }
}
