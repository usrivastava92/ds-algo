package com.ib.graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {

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
      if ((visited[neighbour] == 0 && hasCycle(neighbour, visited, map))
          || visited[neighbour] == 1) {
        return true;
      }
    }
    visited[node] = 2;
    return false;
  }
}
