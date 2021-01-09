package com.leet.daysofcode.year2020.october.week3;

import com.ds.utils.ArrayUtils;
import com.leet.ds.graph.GraphUtils;
import com.leet.ds.graph.Node;

import java.util.*;
import java.util.stream.IntStream;

public class CloneGraph {

    public static void main(String[] args) {
        int[][][] inputs = {{{2, 4}, {1, 3}, {2, 4}, {1, 3}}, {{}}, {}, {{2}, {1}}};
        CloneGraph cloneGraph = new CloneGraph();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i]));
            System.out.println("Output : " + GraphUtils.createAdjMatrix(cloneGraph.cloneGraph(GraphUtils.createGraph(inputs[i]))));
            System.out.println("Expected : " + ArrayUtils.toString(inputs[i]));
        });
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newHead = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, newHead);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> toBeVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            node = queue.poll();
            visited.add(node.val);
            if (!map.containsKey(node.val)) {
                map.put(node.val, new Node(node.val));
            }
            for (Node neighbour : node.neighbors) {
                if (!visited.contains(neighbour.val) && !toBeVisited.contains(neighbour.val)) {
                    queue.add(neighbour);
                    toBeVisited.add(neighbour.val);
                }
                Node neighbourCopy = map.getOrDefault(neighbour.val, new Node(neighbour.val));
                map.get(node.val).neighbors.add(neighbourCopy);
                map.put(neighbour.val, neighbourCopy);
            }
        }
        return newHead;
    }

}
