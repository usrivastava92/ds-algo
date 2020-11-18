package com.leet.ds.graph;

import java.util.*;

public class GraphUtils {

    public static Node createGraph(int[][] adjMatrix) {
        if (adjMatrix == null || adjMatrix.length == 0) {
            return null;
        }
        if (adjMatrix[0].length == 0) {
            return new Node(1);
        }
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjMatrix.length; i++) {
            Node head = map.getOrDefault(i, new Node(i));
            for (Integer adjNode : adjMatrix[i - 1]) {
                Node node = map.getOrDefault(adjNode, new Node(adjNode));
                head.neighbors.add(node);
                map.put(adjNode, node);
            }
            map.put(i, head);
        }
        return map.get(1);
    }

    public static Node createGraph(List<List<Integer>> adjMatrix) {
        if (adjMatrix == null || adjMatrix.size() == 0) {
            return null;
        }
        if (adjMatrix.get(0).size() == 0) {
            return new Node(1);
        }
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjMatrix.size(); i++) {
            Node head = map.getOrDefault(i, new Node(i));
            for (Integer adjNode : adjMatrix.get(i - 1)) {
                Node node = map.getOrDefault(adjNode, new Node(adjNode));
                head.neighbors.add(node);
                map.put(adjNode, node);
            }
            map.put(i, head);
        }
        return map.get(1);
    }

    public static List<List<Integer>> createAdjMatrix(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }
        if (node.neighbors.isEmpty()) {
            return Collections.singletonList(Collections.emptyList());
        }
        Node head = node;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!map.containsKey(node.val)) {
                map.put(node.val, node);
            }
            for (Node adj : node.neighbors) {
                if (!map.containsKey(adj.val)) {
                    queue.add(adj);
                }
            }
        }
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            adjMatrix.add(new ArrayList<>());
            for (Node neighbour : map.get(i).neighbors) {
                adjMatrix.get(i - 1).add(neighbour.val);
            }
        }
        return adjMatrix;
    }


}
