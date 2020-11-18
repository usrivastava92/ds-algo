package com.leet.ds.graph;

import java.util.*;
import java.util.stream.IntStream;

public class FindAllPath {

    public static void main(String[] args) {

        Map<Integer, Set<Integer>> adjMatrix = new HashMap<>();

        IntStream.range(0, 9).forEach(i -> {
            adjMatrix.put(i, new HashSet<>());
        });

        adjMatrix.get(0).add(1);
        adjMatrix.get(1).add(0);
        adjMatrix.get(1).add(2);
        adjMatrix.get(2).add(3);
        adjMatrix.get(3).add(4);
        adjMatrix.get(3).add(5);
        adjMatrix.get(5).add(6);

        System.out.println(printAllPAthBetween(1, 4, adjMatrix));
    }


    public static boolean printAllPAthBetween(int a, int b, Map<Integer, Set<Integer>> graph) {
        int parent = a;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(a);
        while (stack.isEmpty()) {
            int node = stack.pop();
            parent = a;
            for (int neighbour : graph.get(node)) {

            }
        }
        return true;
    }

}
