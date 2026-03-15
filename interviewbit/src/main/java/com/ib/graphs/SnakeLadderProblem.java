package com.ib.graphs;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SnakeLadderProblem {

  public int snakeLadder(int[][] A, int[][] B) {
    Map<Integer, Integer> ladders = new HashMap<>();
    Map<Integer, Integer> snakes = new HashMap<>();
    for (int[] ladder : A) {
      ladders.put(ladder[0], ladder[1]);
    }
    for (int[] snake : B) {
      snakes.put(snake[0], snake[1]);
    }
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int i = 1; i < 100; i++) {
      Map<Integer, Integer> map = graph.getOrDefault(i, new HashMap<>());
      if (snakes.containsKey(i)) {
        map.put(snakes.get(i), 0);
        graph.put(i, map);
        continue;
      }
      if (ladders.containsKey(i)) {
        map.put(ladders.get(i), 0);
        graph.put(i, map);
        continue;
      }
      for (int dice = 1; i + dice <= 100 && dice <= 6; dice++) {
        int next = i + dice;
        map.put(next, 1);
      }
      graph.put(i, map);
    }
    return applyDijkstra(graph).getOrDefault(100, -1);
  }

  private Map<Integer, Integer> applyDijkstra(Map<Integer, Map<Integer, Integer>> graph) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 0);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
    minHeap.add(1);
    while (!minHeap.isEmpty()) {
      Integer nearest = minHeap.poll();
      for (Map.Entry<Integer, Integer> neighbour :
          graph.getOrDefault(nearest, Collections.emptyMap()).entrySet()) {
        Integer currDist = map.get(neighbour.getKey());
        int weight = neighbour.getValue();
        int minifiedWeight = -1;
        if (currDist == null) {
          minifiedWeight = map.get(nearest) + weight;
        } else {
          minifiedWeight = Integer.min(map.get(nearest) + weight, currDist);
        }
        boolean isVisited = map.containsKey(neighbour.getKey());
        map.put(neighbour.getKey(), minifiedWeight);
        if (!isVisited) {
          minHeap.add(neighbour.getKey());
        }
      }
    }
    return map;
  }
}
