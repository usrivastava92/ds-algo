package com.leet.daysofcode.april.week2;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {


    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] arr = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight.lastStoneWeight(arr));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (!queue.isEmpty()) {
                int b = queue.poll();
                queue.add(Math.abs(a - b));
            } else {
                ans = a;
            }
        }
        return ans;
    }

}
