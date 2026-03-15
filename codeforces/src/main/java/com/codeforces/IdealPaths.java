package com.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdealPaths {

  public static int countIdealPaths(int n, int[] parent) {
    List<Integer>[] graph = buildGraph(n, parent);
    int idealPaths = 0;

    for (int start = 1; start <= n; start++) {
      DisjointSet dsu = new DisjointSet(n + 1);
      boolean[] active = new boolean[n + 1];

      for (int end = start; end <= n; end++) {
        active[end] = true;

        for (int neighbor : graph[end]) {
          if (neighbor >= start && active[neighbor]) {
            dsu.union(end, neighbor);
          }
        }

        if (end > start && dsu.find(start) == dsu.find(end)) {
          idealPaths++;
        }
      }
    }

    return idealPaths;
  }

  @SuppressWarnings("unchecked")
  private static List<Integer>[] buildGraph(int n, int[] parent) {
    List<Integer>[] graph = new ArrayList[n + 1];
    for (int node = 1; node <= n; node++) {
      graph[node] = new ArrayList<>();
    }

    for (int node = 1; node <= n; node++) {
      int parentNode = parent[node - 1];
      if (parentNode == 0) {
        continue;
      }

      graph[node].add(parentNode);
      graph[parentNode].add(node);
    }

    return graph;
  }

  private static final class DisjointSet {
    private final int[] parent;
    private final int[] rank;

    private DisjointSet(int size) {
      this.parent = new int[size];
      this.rank = new int[size];

      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    private int find(int node) {
      if (parent[node] != node) {
        parent[node] = find(parent[node]);
      }
      return parent[node];
    }

    private void union(int first, int second) {
      int rootFirst = find(first);
      int rootSecond = find(second);

      if (rootFirst == rootSecond) {
        return;
      }

      if (rank[rootFirst] < rank[rootSecond]) {
        parent[rootFirst] = rootSecond;
      } else if (rank[rootFirst] > rank[rootSecond]) {
        parent[rootSecond] = rootFirst;
      } else {
        parent[rootSecond] = rootFirst;
        rank[rootFirst]++;
      }
    }
  }

  public static void main(String[] args) {
    int n1 = 8;
    int[] a1 = {0, 7, 4, 2, 2, 3, 1, 5};
    int output1 = countIdealPaths(n1, a1);
    System.out.println("Example 1:");
    System.out.println("Input n: " + n1);
    System.out.println("Input a: " + Arrays.toString(a1));
    System.out.println("Output: " + output1);
    System.out.println("Expected: 10\n");

    int n2 = 4;
    int[] a2 = {2, 0, 1, 3};
    int output2 = countIdealPaths(n2, a2);
    System.out.println("Example 2:");
    System.out.println("Input n: " + n2);
    System.out.println("Input a: " + Arrays.toString(a2));
    System.out.println("Output: " + output2);
    System.out.println("Expected: 4");
  }
}
