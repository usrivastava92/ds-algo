package com.ib.graphs;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {
        int[] As = {5, 3, 88};
        int[][][] edges = {{{1, 2}, {1, 3}, {2, 3}, {1, 4}, {4, 5}}, {{1, 2}, {1, 3}}, {{6, 45}, {29, 81}, {7, 8}, {67, 76}, {40, 76}, {7, 73}, {9, 20}, {56, 63}, {52, 57}, {22, 31}, {26, 76}, {14, 58}, {31, 69}, {30, 31}, {56, 85}, {22, 57}, {12, 42}, {19, 78}, {12, 85}, {72, 85}, {3, 41}, {32, 87}, {31, 48}, {17, 81}, {2, 63}, {25, 78}, {49, 51}, {30, 61}, {7, 54}, {79, 80}, {23, 37}, {25, 32}, {54, 63}, {7, 28}, {41, 58}, {45, 52}, {77, 78}, {26, 53}, {54, 83}, {26, 75}, {61, 72}, {57, 82}, {9, 36}, {30, 73}, {12, 17}, {24, 55}, {47, 68}, {12, 64}, {35, 77}, {33, 86}, {2, 50}, {17, 41}, {27, 70}, {7, 43}, {62, 73}, {3, 60}, {49, 58}, {32, 52}, {26, 73}, {13, 78}, {8, 68}, {17, 68}, {34, 51}, {48, 51}, {8, 11}, {31, 78}, {22, 53}, {2, 64}, {71, 80}, {11, 81}, {86, 88}, {9, 67}, {6, 18}, {40, 53}, {52, 77}, {21, 52}, {47, 71}, {48, 50}, {16, 76}, {16, 86}, {3, 71}, {10, 59}, {33, 73}, {52, 68}, {24, 66}, {32, 72}, {3, 4}, {34, 35}, {57, 76}, {25, 33}, {20, 59}, {29, 44}, {50, 56}, {41, 82}, {25, 85}, {17, 35}, {34, 52}, {62, 68}, {5, 26}, {13, 39}, {25, 56}, {5, 12}, {85, 87}, {20, 86}, {63, 80}, {6, 53}, {28, 78}, {47, 65}, {28, 64}, {7, 51}, {41, 59}}};
        int[] outputs = {1, 0, 1};
        CycleInUndirectedGraph cycleInUndirectedGraph = new CycleInUndirectedGraph();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A -> " + As[i] + " edges -> " + Arrays.deepToString(edges[i]));
            System.out.println("Output using DFS : " + cycleInUndirectedGraph.solve(As[i], edges[i]));
            System.out.println("Output using disjoint : " + cycleInUndirectedGraph.solveUsingDisjoint(As[i], edges[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int solve(int A, int[][] B) {
        if (A <= 1) {
            return 0;
        }
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : B) {
            Set<Integer> list1 = adjList.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> list2 = adjList.getOrDefault(edge[1], new HashSet<>());
            list1.add(edge[1]);
            list2.add(edge[0]);
            adjList.put(edge[0], list1);
            adjList.put(edge[1], list2);
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Pair> stack = new Stack<>();
        for (int i = 1; i <= A; i++) {
            if (!visited.contains(i)) {
                stack.push(new Pair(i, 0));
                visited.add(i);
                while (!stack.isEmpty()) {
                    Pair node = stack.pop();
                    for (Integer children : adjList.getOrDefault(node.getNode(), Collections.emptySet())) {
                        if (!visited.contains(children)) {
                            stack.push(new Pair(children, node.getNode()));
                            visited.add(children);
                        } else if (!children.equals(node.getParent())) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }


    public int solveUsingDisjoint(int A, int[][] B) {
        if (A <= 1) {
            return 0;
        }
        int[] sets = new int[A + 1];
        Arrays.fill(sets, -1);
        for (int[] edge : B) {
            if (union(sets, edge[0], edge[1])) {
                return 1;
            }
        }
        return 0;
    }

    private int parent(int[] sets, int child) {
        if (sets[child] < 0) {
            return child;
        }
        return parent(sets, sets[child]);
    }

    private boolean union(int[] sets, int child1, int child2) {
        int parent1 = parent(sets, child1);
        int parent2 = parent(sets, child2);
        int parent1Val = sets[parent1];
        int parent2Val = sets[parent2];
        System.out.println(parent1 + " : " + parent2);
        if (parent1 == parent2) {
            return true;
        }
        if (Math.abs(sets[parent1]) >= Math.abs(sets[parent2])) {
            sets[parent2] = parent1;
            sets[parent1] += parent2Val;
        } else {
            sets[parent1] = parent2;
            sets[parent2] += parent1Val;
        }
        return false;
    }

    private static class Pair {
        private final int node;
        private final int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }

        public int getNode() {
            return node;
        }

        public int getParent() {
            return parent;
        }
    }

}
