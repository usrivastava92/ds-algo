package com.ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6,5));
        int A = 3;
        MagicianAndChocolates magicianAndChocolates = new MagicianAndChocolates();
        System.out.println(magicianAndChocolates.nchoc(A, B));
    }

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        for (Integer i : B) {
            pq.add(i);
        }
        int mod = 1000000007;
        while (A-- > 0) {
            System.out.println(pq);
            if (!pq.isEmpty()) {
                Integer i = pq.poll();
                max += i;
                pq.add(i / 2);
            }
        }
        return max % mod;
    }
}
