package com.codeforces;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ClimbingUpAndDown {

  public static void main(String[] args) {
    // Test Case 1
    int n1 = 10;
    int m1 = 3;
    int[] start1 = {1, 7, 3};
    int[] end1 = {3, 9, 6};
    System.out.println("Test 1 - Expected: 6, Got: " + solve(n1, m1, start1, end1));

    // Test Case 2
    int n2 = 100;
    int m2 = 2;
    int[] start2 = {45, 5};
    int[] end2 = {55, 10};
    System.out.println("Test 2 - Expected: 1, Got: " + solve(n2, m2, start2, end2));

    // Test Case 3: reaching a higher floor requires going down first
    int n3 = 10;
    int m3 = 3;
    int[] start3 = {1, 5, 2};
    int[] end3 = {5, 2, 10};
    System.out.println("Test 3 - Expected: 10, Got: " + solve(n3, m3, start3, end3));
  }

  /**
   * Find the highest floor you can reach using M elevators
   *
   * @param n Total number of floors
   * @param m Number of elevators
   * @param start Array representing the starting floor of each elevator
   * @param end Array representing the ending floor of each elevator
   * @return The highest floor you can reach
   */
  public static int solve(int n, int m, int[] start, int[] end) {
    List<List<Integer>> graph = new ArrayList<>(n + 1);
    for (int floor = 0; floor <= n; floor++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int u = start[i];
      int v = end[i];

      if (u < 1 || u > n || v < 1 || v > n) {
        continue;
      }

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    Queue<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    queue.offer(1);
    visited.add(1);

    int maxFloor = 1;
    while (!queue.isEmpty()) {
      int currentFloor = queue.poll();
      maxFloor = Math.max(maxFloor, currentFloor);

      for (int nextFloor : graph.get(currentFloor)) {
        if (visited.add(nextFloor)) {
          queue.offer(nextFloor);
        }
      }
    }

    return maxFloor;
  }
}
