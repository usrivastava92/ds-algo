package com.ib.graphs;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class CommutableIslands {

    public static void main(String[] args) {
        int[] As = {4, 4, 3};
        int[][][] Bs = {{{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}}, {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}}, {{1, 2, 10}, {2, 3, 5}, {1, 3, 9}}};
        int[] outputs = {6, 6, 14};
        CommutableIslands commutableIslands = new CommutableIslands();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(Bs[i]);
            int output = commutableIslands.solve(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

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
