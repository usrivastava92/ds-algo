package com.prep.practice;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 2}, {1, 3}, {2, 3}}, {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}};
        int[][] outputs = {{2, 3}, {1, 4}};
        RedundantConnection redundantConnection = new RedundantConnection();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.deepToString(inputs[i]));
            int[] output = redundantConnection.findRedundantConnection(inputs[i]);
            System.out.println("Output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] parents = IntStream.rangeClosed(0, edges.length).toArray();
        for (int[] edge : edges) {
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            if (parent1 == parent2) {
                return edge;
            }
            parents[parent1] = parent2;
        }
        return null;
    }

    private int find(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }


}
