package com.leet.ds.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][][] mats = {{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}},
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}}
        };
        int[] ks = {2, 3};
        int testCase = 1;
        TheKWeakestRowsInAMatrix theKWeakestRowsInAMatrix = new TheKWeakestRowsInAMatrix();
        System.out.println(Arrays.toString(theKWeakestRowsInAMatrix.kWeakestRows(mats[testCase], ks[testCase])));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            int comp = Integer.compare(arr1[1], arr2[1]);
            if (comp == 0) {
                return Integer.compare(arr1[0], arr2[0]);
            }
            return comp;
        });
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int element : mat[i]) {
                sum += element;
            }
            pq.add(new int[]{i, sum});
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
