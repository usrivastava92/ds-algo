package com.leet.ds.array;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersect(nums1,nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int newFreq = map.get(num) - 1;
                if (newFreq == 0) {
                    map.remove(num);
                } else {
                    map.put(num, newFreq);
                }
                list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
