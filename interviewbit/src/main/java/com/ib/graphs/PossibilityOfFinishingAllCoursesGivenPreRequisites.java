package com.ib.graphs;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {

    public static void main(String[] args) {
        int[] As = {3, 2, 32};
        int[][] Bs = {{1, 2}, {1, 2}, {}};
        int[][] Cs = {{2, 3}, {2, 1}, {}};
        int[] outputs = {1, 0, 1};
        PossibilityOfFinishingAllCoursesGivenPreRequisites possibilityOfFinishingAllCoursesGivenPreRequisites = new PossibilityOfFinishingAllCoursesGivenPreRequisites();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : a : " + As[i] + " b : " + Arrays.toString(Bs[i]) + " c : " + Arrays.toString(Cs[i]));
            int output = possibilityOfFinishingAllCoursesGivenPreRequisites.solve(As[i], Bs[i], Cs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }


    public int solve(int A, int[] B, int[] C) {
        if (A <= 0 && (B == null || B.length == 0 || C == null || C.length == 0)) {
            return 0;
        }
        if (B == null || B.length == 0 || C == null || C.length == 0) {
            return 1;
        }
        int[] visited = new int[A + 1];
        int[] inDegree = new int[A + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int len = B.length;
        for (int i = 0; i < len; i++) {
            int from = B[i];
            int to = C[i];
            inDegree[to]++;
            Set<Integer> set = map.getOrDefault(from, new HashSet<>());
            set.add(to);
            map.put(from, set);
        }
        for (int i = 0; i <= A; i++) {
            if (visited[i] == 0 && inDegree[i] == 0) {
                if (hasCycle(i, visited, map)) {
                    return 0;
                }
            }
        }
        return allVisited(visited);
    }

    private int allVisited(int[] visited) {
        for (int j : visited) {
            if (j == 0) {
                return 0;
            }
        }
        return 1;
    }


    private boolean hasCycle(int node, int[] visited, Map<Integer, Set<Integer>> map) {
        if (visited[node] == 1) {
            return true;
        }
        if (visited[node] == 2) {
            return false;
        }
        visited[node] = 1;
        for (int neighbour : map.getOrDefault(node, Collections.emptySet())) {
            if ((visited[neighbour] == 0 && hasCycle(neighbour, visited, map)) || visited[neighbour] == 1) {
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }


}
