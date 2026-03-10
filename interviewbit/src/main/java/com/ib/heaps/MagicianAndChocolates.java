package com.ib.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        for (Integer i : B) {
            pq.add(i);
        }
        int mod = 1000000007;
        while (A-- > 0) {
            if (!pq.isEmpty()) {
                Integer i = pq.poll();
                max += i;
                pq.add(i / 2);
            }
        }
        return max % mod;
    }
}
