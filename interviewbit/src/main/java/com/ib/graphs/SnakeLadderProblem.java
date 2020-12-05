package com.ib.graphs;

import com.ds.graph.DirectedWeightedGraph;
import com.ds.graph.GraphUtils;
import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class SnakeLadderProblem {

    public static void main(String[] args) {
        int[][][] As = {{{32, 62}, {42, 68}, {12, 98}}, {{8, 52}, {6, 80}, {26, 42}, {2, 72}}, {{3, 54}, {37, 100}}};
        int[][][] Bs = {{{95, 13}, {97, 25}, {93, 37}, {79, 27}, {75, 19}, {49, 47}, {67, 17}}, {{51, 19}, {39, 11}, {37, 29}, {81, 3}, {59, 5}, {79, 23}, {53, 7}, {43, 33}, {77, 21}}, {{56, 33}}};
        int[] outputs = {3, 5, 3};
        SnakeLadderProblem snakeLadderProblem = new SnakeLadderProblem();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : " + Arrays.deepToString(As[i]) + " B : " + Arrays.deepToString(Bs[i]));
            int output = snakeLadderProblem.snakeLadder(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

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
            for (Map.Entry<Integer, Integer> neighbour : graph.getOrDefault(nearest, Collections.emptyMap()).entrySet()) {
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
