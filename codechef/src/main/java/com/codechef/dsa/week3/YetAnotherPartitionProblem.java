package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.util.*;

public class YetAnotherPartitionProblem {


    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        int n = reader.nextInt();
        int q = reader.nextInt();

        int[] A = new int[n];
        TreeSet<Integer> transitionIndex = new TreeSet<>();

        A[0] = reader.nextInt();
        for (int i = 1; i < n; i++) {
            A[i] = reader.nextInt();
            if (A[i] % A[i - 1] != 0) {
                transitionIndex.add(i);
            }
        }

        while (q-- > 0) {
            int operation = reader.nextInt();
            if (operation == 1) {
                int i = reader.nextInt() - 1;
                int j = reader.nextInt();
                A[i] = j;
                int prev = i - 1;
                int next = i + 1;
                if (prev > -1) {
                    if (A[i] % A[prev] == 0) {
                        transitionIndex.remove(i);
                    } else {
                        transitionIndex.add(i);
                    }
                }
                if (next < n) {
                    if (A[next] % A[i] == 0) {
                        transitionIndex.remove(next);
                    } else {
                        transitionIndex.add(next);
                    }
                }
            } else {
                int i = reader.nextInt() - 1;
                Integer ans = transitionIndex.floor(i);
                if (ans == null) {
                    System.out.println(1);
                } else {
                    System.out.println(ans + 1);
                }
            }
        }

        reader.close();
    }


}
