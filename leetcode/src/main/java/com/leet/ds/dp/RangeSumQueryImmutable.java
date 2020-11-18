package com.leet.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {

    }

}

class NumArray {

    private Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (map.containsKey(i)) {
            Map<Integer, Integer> subMap = map.get(i);
            if (subMap.containsKey(j)) {
                return subMap.get(j);
            } else {
                int x = j;
                int y = j;
                while (!subMap.containsKey(x) && !subMap.containsKey(y)) {

                }
            }
        }
        return 0;
    }
}
