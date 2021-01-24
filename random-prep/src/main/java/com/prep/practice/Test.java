package com.prep.practice;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Test test = new Test();
        System.out.println(Arrays.toString(test.twoSum(nums, target)));
    }

    /*

    O(n^2)

    O(nlogn)

    O(n)

    O(logn)

    */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int a = nums[i];
            int b = target - a;
            int index = contains(nums, b);
            if (index != -1 && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }

    private int contains(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }


    private static final class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] firstHalf = new int[n];
            int[] secondHalf = new int[n];
            int[] answer = new int[nums.length];

            // Splitting
            int len = nums.length;
            for (int i = 0; i < n; i++) {
                firstHalf[i] = nums[i];
            }
            for (int i = n; i < len; i++) {
                secondHalf[i - n] = nums[i];
            }

            // mixing
            int x = 0;
            int y = 0;
            for (int i = 0; i < len; ) {
                answer[i++] = firstHalf[x++];
                answer[i++] = secondHalf[y++];
            }

            return answer;
        }
    }

}

/*
15,7,2,11
2, 7, 11, 15
*/

/*
Set<String> -> contains("abc") -> O(1)
List<String> -> contains("abc") -> O(n)
Map<String,Integer> -> containsKey("abc") -> O(1)
 */