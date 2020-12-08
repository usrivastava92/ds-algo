package com.ib.graphs;

import java.util.*;

public class CycleInDirectedGraph {

    public static void main(String[] args) {

    }

    public int solve(int A, int[][] B) {
        if (A <= 1) {
            return 0;
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : B) {
            Set<Integer> set1 = adj.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> set2 = adj.getOrDefault(edge[1], new HashSet<>());
            set1.add(edge[1]);
            adj.put(edge[0], set1);
            adj.put(edge[1], set2);
        }
        return hasCycle(adj, 1, new int[A + 1]);
    }

    private int hasCycle(Map<Integer, Set<Integer>> adj, int node, int[] visited) {
        if (visited[node] == 1) {
            return 1;
        }
        if (visited[node] == 2) {
            return 0;
        }
        visited[node] = 1;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 1 || (visited[neighbour] == 0 && hasCycle(adj, neighbour, visited) == 1)) {
                return 1;
            }
        }
        visited[node] = 2;
        return 0;
    }

}


class Solution {
    ArrayList<ArrayList<Integer>> graph;

    public int solve(int A, int[][] B) {
        if (A == 1) return 0;
        graph = new ArrayList<>();
//visit = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }
        constructGraph(B);
        boolean visited[] = new boolean[A];
        boolean recStack[] = new boolean[A];
        for (int i = 0; i < A; i++) {
            if (isCyclic(i, visited, recStack))
                return 1;
        }
        return 0;
    }

    public boolean isCyclic(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            if (isCyclic(graph.get(i).get(j), visited, recStack))
                return true;
            ;
        }
        recStack[i] = false;
        return false;
    }

    public void constructGraph(int[][] B) {
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u - 1).add(v - 1);
        }
    }
}