package com.prep.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[][] nums1 = {{1, 3}, {1, 2}, {0, 0}, {}, {2}, {}, {3, 4}, {3}, {2, 3, 4}};
        int[][] nums2 = {{2}, {3, 4}, {0, 0}, {1}, {}, {2, 3}, {}, {-2, -1}, {1}};
        double[] outputs = {2.00000, 2.5, 0.0, 1.0, 2.0, 2.5, 3.5, -1.0, 2.5};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        IntStream.range(0, nums1.length).forEachOrdered(i -> {
            System.out.println("Input : nums1 -> " + Arrays.toString(nums1[i]) + " | nums2 -> " + Arrays.toString(nums2[i]));
            System.out.println("Output : " + medianOfTwoSortedArrays.findMedianSortedArrays(nums1[i], nums2[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int gap = totalLen;
        while (true) {
            int oldGap = gap;
            gap = (int) Math.ceil((gap * 1.0) / 2);
            if (gap == oldGap) {
                break;
            }
            int firstIndex = 0;
            while (true) {
                int secondIndex = firstIndex + gap;
                if (secondIndex >= totalLen) {
                    break;
                }
                if (firstIndex >= nums1.length) {
                    int secondArrIndex1 = remainderWithCheck(firstIndex, nums1.length);
                    int secondArrIndex2 = remainderWithCheck(secondIndex, nums1.length);
                    if (nums2[secondArrIndex1] > nums2[secondArrIndex2]) {
                        int temp = nums2[secondArrIndex1];
                        nums2[secondArrIndex1] = nums2[secondArrIndex2];
                        nums2[secondArrIndex2] = temp;
                    }
                } else if (secondIndex >= nums1.length) {
                    int secondArrIndex = remainderWithCheck(secondIndex, nums1.length);
                    if (nums1[firstIndex] > nums2[secondArrIndex]) {
                        int temp = nums1[firstIndex];
                        nums1[firstIndex] = nums2[secondArrIndex];
                        nums2[secondArrIndex] = temp;
                    }
                } else {
                    if (nums1[firstIndex] > nums1[secondIndex]) {
                        int temp = nums1[firstIndex];
                        nums1[firstIndex] = nums1[secondIndex];
                        nums1[secondIndex] = temp;
                    }
                }
                firstIndex++;
            }
        }
        System.out.println("array after modification " + Arrays.toString(nums1) + " : " + Arrays.toString(nums2));
        if (totalLen % 2 == 0) {
            int greaterIndex = totalLen / 2;
            int smallerIndex = greaterIndex - 1;
            if (smallerIndex >= nums1.length) {
                return ((nums2[remainderWithCheck(smallerIndex, nums1.length)] + nums2[remainderWithCheck(greaterIndex, nums1.length)]) * 1.0d) / 2;
            } else if (greaterIndex >= nums1.length) {
                return ((nums1[smallerIndex] + nums2[remainderWithCheck(greaterIndex, nums1.length)]) * 1.0d) / 2;
            } else {
                return ((nums1[smallerIndex] + nums1[greaterIndex]) * 1.0d) / 2;
            }
        }
        int medianIndex = totalLen / 2;
        if (medianIndex >= nums1.length) {
            return nums2[remainderWithCheck(medianIndex, nums1.length)];
        }
        return nums1[medianIndex];
    }

    private int remainderWithCheck(int divident, int divisor) {
        return divident - divisor;
    }

}
