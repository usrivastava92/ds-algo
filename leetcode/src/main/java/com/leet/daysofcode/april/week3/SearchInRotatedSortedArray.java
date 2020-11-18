package com.leet.daysofcode.april.week3;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int target = 2;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivot = findPivot(nums, 0, nums.length - 1);
        System.out.println(pivot);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        return binarySearch(nums, pivot, nums.length - 1, target);
    }

    public int binarySearch(int[] arr, int low, int high, final int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public int findPivot(int[] arr, int low, int high) {
        if (low >= high || arr[low] <= arr[high]) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (mid == low) {
            if (arr[low] > arr[high]) {
                return high;
            }
            return -1;
        }
        if (arr[mid - 1] > arr[mid]) {
            return mid;
        }
        if (arr[mid] >= arr[low]) {
            return findPivot(arr, mid, high);
        }
        return findPivot(arr, low, mid);
    }

}
