package com.ib.heaps;

import java.util.*;

public class NMaxPairCombinations {


    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (Integer a : A) {
            for (Integer b : B) {
                queue.add(a + b);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(queue.poll());
        }

        return result;
    }
}
