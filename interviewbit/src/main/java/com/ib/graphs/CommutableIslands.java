package com.ib.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class CommutableIslands {

    public int solve(int A, int[][] B) {
        if (A <= 1 || B == null || B.length == 0 || B[0].length == 0) {
            return 0;
        }
        int[] parents = IntStream.rangeClosed(0, A + 1).toArray();
        Arrays.sort(B, Comparator.comparingInt(edge -> edge[2]));
        int weight = 0;
        for (int[] edge : B) {
            int fromParent = find(parents, edge[0]);
            int toParent = find(parents, edge[1]);
            if (fromParent == toParent) {
                continue;
            }
            weight += edge[2];
            union(parents, edge[0], edge[1]);
        }
        return weight;
    }

    private int find(int[] parents, int node) {
        while (parents[node] != node) {
            node = parents[node];
        }
        return node;
    }

    private void union(int[] parents, int from, int to) {
        int fromParent = find(parents, from);
        int toParent = find(parents, to);
        if (fromParent == toParent) {
            return;
        }
        parents[fromParent] = toParent;
    }

}
