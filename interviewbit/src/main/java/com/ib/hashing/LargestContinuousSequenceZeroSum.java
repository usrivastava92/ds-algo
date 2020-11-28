package com.ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {


    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum largestContinuousSequenceZeroSum = new LargestContinuousSequenceZeroSum();
        System.out.println(largestContinuousSequenceZeroSum.lszero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4))));

    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLen = -1;
        for (int i=0;i<A.size();i++) {
            System.out.println(sum+" "+A.get(i)+" "+map);
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int tempLen= i - map.get(sum);
                if (maxLen < tempLen) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLen = tempLen;
                }
            }
            else {
                map.put(sum, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(start >= 0) {
            for(int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }

        return result;
    }

}
