package com.ds.graph;

import com.ds.utils.NumberUtils;

import java.util.*;
import java.util.stream.IntStream;

public class GraphUtils {

    private GraphUtils() {
    }

    public static int minDistUsingDijkstra(Map<Integer, Set<Integer>> adjList) {
        return 1;
    }

    public static int minDistUsingDijkstra(int[][] adjMatrix) {
        return 1;
    }

    public static int[][] createRandomDirectedAdjMatrix(int numberOfNodes) {
        int[][] matrix = new int[numberOfNodes][numberOfNodes];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j && matrix[j][i] == 0) {
                    matrix[i][j] = NumberUtils.getRandomInt(0, 2);
                }
            }
        }
        return matrix;
    }

    public static int[][] createRandomUndirectedAdjMatrix(int numberOfNodes) {
        int[][] matrix = new int[numberOfNodes][numberOfNodes];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                matrix[i][j] = NumberUtils.getRandomInt(0, 2);
                matrix[j][i] = matrix[i][j];
            }
        }
        return matrix;
    }

    public static Map<Integer, Set<Integer>> createRandomDAGAdjList(int numberOfNodes) {
        Map<Integer, Set<Integer>> adjList = createRandomDirectedAdjList(numberOfNodes);
        while (hasCycle(adjList)) {
            adjList = createRandomDirectedAdjList(numberOfNodes);
        }
        return adjList;
    }

    public static Map<Integer, Set<Integer>> createRandomDirectedAdjList(int numberOfNodes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        IntStream.range(0, numberOfNodes).forEach(i -> map.put(i, new HashSet<>()));
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if (i != j && !map.get(j).contains(i) && NumberUtils.getRandomInt(0, 2) == 1) {
                    map.get(i).add(j);
                }
            }
        }
        return map;
    }

    public static Map<Integer, Set<Integer>> createRandomUndirectedAdjList(int numberOfNodes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        IntStream.range(0, numberOfNodes).forEach(i -> map.put(i, new HashSet<>()));
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = i + 1; j < numberOfNodes; j++) {
                if (NumberUtils.getRandomInt(0, 2) == 1) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        return map;
    }

    public static List<Integer> getDfs(Map<Integer, Set<Integer>> adjList) {
        if (adjList == null || adjList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> dfs = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int startNode = -1;
        for (int i : adjList.keySet()) {
            startNode = i;
            break;
        }
        stack.push(startNode);
        visited.add(startNode);
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            dfs.add(pop);
            for (int neighbour : adjList.get(pop)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        return dfs;
    }

    public static List<Integer> getBfs(Map<Integer, Set<Integer>> adjList) {
        if (adjList == null || adjList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> bfs = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int startNode = -1;
        for (int i : adjList.keySet()) {
            startNode = i;
            break;
        }
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            bfs.add(pop);
            for (int neighbour : adjList.get(pop)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }

    public static boolean hasCycle(Map<Integer, Set<Integer>> adjList) {
        Integer node = null;
        for (Integer i : adjList.keySet()) {
            node = i;
            break;
        }
        return hasCycle(adjList, node, new HashMap<>());
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> adjList, Integer node, Map<Integer, Integer> map) {
        if (!map.containsKey(node)) {
            map.put(node, 1);
            for (Integer children : adjList.get(node)) {
                if ((!map.containsKey(children) && hasCycle(adjList, children, map)) || map.get(children) == 1) {
                    return true;
                }
            }
            map.put(node, 2);
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> adjList = createRandomDirectedAdjList(5);
        System.out.println(adjList);
        System.out.println(hasCycle(adjList));
    }

}
