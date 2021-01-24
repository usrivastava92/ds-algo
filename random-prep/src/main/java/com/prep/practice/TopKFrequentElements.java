package com.prep.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        if (nums == null || nums.length==0) return ans;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(j.getValue(),i.getValue()));
        maxHeap.addAll(map.entrySet());
        for (int i=0; i<k ;i++) {
            ans[i] = maxHeap.poll().getKey();
        }
        return ans;
    }

}
