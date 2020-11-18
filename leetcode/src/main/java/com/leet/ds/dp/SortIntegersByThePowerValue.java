package com.leet.ds.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersByThePowerValue {

    public static void main(String[] args) {
        SortIntegersByThePowerValue sortIntegersByThePowerValue = new SortIntegersByThePowerValue();
        int[] low = {12};
        int[] high = {15};
        int[] k = {2};
        int testCase = 0;
        System.out.println(sortIntegersByThePowerValue.getKth(low[testCase], high[testCase], k[testCase]));
    }


    private Map<Integer, Integer> dp = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
            int comp = Integer.compare(calculateSteps(i), calculateSteps(j));
            if (comp == 0) {
                return Integer.compare(i, j);
            }
            return comp;
        });

        for (int i = lo; i <= hi; i++) {
            pq.add(i);
        }

        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }

    private int calculateSteps(int num) {
        if (num <= 1) {
            return 0;
        }
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        int ans = -1;
        if (num % 2 == 0) {
            ans = 1 + calculateSteps(num / 2);
        } else {
            ans = 1 + calculateSteps(3 * num + 1);
        }
        dp.put(num, ans);
        return dp.get(num);
    }


}
