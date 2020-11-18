package com.leet.ds.linkedlist;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QueriesOnAPermutationWithKey {

    public static void main(String[] args) {
        int[][] queries = {{3, 1, 2, 1},{4,1,2,2}};
        int[] m = {5,4};
        int testCase =1;
        QueriesOnAPermutationWithKey queriesOnAPermutationWithKey = new QueriesOnAPermutationWithKey();
        System.out.println(Arrays.toString(queriesOnAPermutationWithKey.processQueries(queries[testCase], m[testCase])));
    }

    public int[] processQueries(int[] queries, int m) {
        int[] arr = IntStream.range(1, m+1).toArray();
        int[] ans = new int[queries.length];
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < queries.length; j++) {
            int query = queries[j];
            int i = 0;
            int prev = query;
            while (arr[i] != query) {
                int bkp = arr[i];
                arr[i] = prev;
                prev = bkp;
                i++;
            }
            arr[i] = prev;
            ans[j] = i;
            System.out.println(Arrays.toString(arr));
        }
        return ans;
    }

}
