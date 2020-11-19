package com.ds.graph;

import com.ds.utils.NumberUtils;
import javafx.util.Pair;

import java.util.*;

public class GraphUtils {

    private GraphUtils() {
    }

    public static <Node> Map<Node, Integer> applyDijkstra(IWeightedGraph<Node, Integer> graph, Node start) {
        Map<Node, Integer> map = new HashMap<>();
        map.put(start, 0);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        minHeap.add(start);
        while (!minHeap.isEmpty()) {
            Node nearest = minHeap.poll();
            for (Map.Entry<Node, Integer> neighbourEntry : graph.getNeighboursWithWeights(nearest).entrySet()) {
                Node neighbour = neighbourEntry.getKey();
                Integer weight = neighbourEntry.getValue();
                Integer currDist = map.get(neighbour);
                int minifiedWeight = -1;
                if (currDist == null) {
                    minifiedWeight = map.get(nearest) + weight;
                } else {
                    minifiedWeight = Integer.min(map.get(nearest) + weight, currDist);
                }
                boolean isVisited = map.containsKey(neighbour);
                map.put(neighbour, minifiedWeight);
                if (!isVisited) {
                    minHeap.add(neighbour);
                }
            }
        }
        return map;
    }

    /**
     * This method returns weight for min spanning tree, it is implemented using Kruskal's algorithm
     * @param graph
     * @param <Node>
     * @return weight of min spanning tree
     */
    public static <Node> Integer applyKruskal(IWeightedGraph<Node, Integer> graph) {
        if (graph == null || graph.isEmpty()) {
            return null;
        }
        Set<Node> visited = new HashSet<>();
        int minWeight = 0;
        PriorityQueue<Pair<Node, Pair<Node, Integer>>> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.getValue().getValue()));
        minHeap.addAll(graph.getAllEdgesWithWeights());
        while (!minHeap.isEmpty()) {
            Pair<Node, Pair<Node, Integer>> minEdge = minHeap.poll();
            Node from = minEdge.getKey();
            Node to = minEdge.getValue().getKey();
            Integer weight = minEdge.getValue().getValue();
            if (!visited.contains(from) || !visited.contains(to)) {
                visited.add(from);
                visited.add(to);
                minWeight += weight;
            }
        }
        return minWeight;
    }

    /**
     * This method returns weight for min spanning tree, it is implemented using Prim's algorithm
     * @param graph
     * @param <Node>
     * @return weight of min spanning tree
     */
    public static <Node> Integer applyPrims(IWeightedGraph<Node, Integer> graph) {
        if (graph == null || graph.isEmpty()) {
            return null;
        }
        Set<Node> visited = new HashSet<>();
        int minWeight = 0;
        PriorityQueue<Pair<Node, Pair<Node, Integer>>> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.getValue().getValue()));
        minHeap.addAll(graph.getAllEdgesWithWeights());
        while (!minHeap.isEmpty()) {
            Pair<Node, Pair<Node, Integer>> minEdge = minHeap.poll();
            Node from = minEdge.getKey();
            Node to = minEdge.getValue().getKey();
            Integer weight = minEdge.getValue().getValue();
            if (!visited.contains(from) || !visited.contains(to)) {
                visited.add(from);
                visited.add(to);
                minWeight += weight;
            }
        }
        return minWeight;
    }

    public static DirectedWeightedGraph<Integer, Integer> createRandomDirectedWeightedGraph(int numberOfNodes) {
        DirectedWeightedGraph<Integer, Integer> graph = new DirectedWeightedGraph<>();
        createRandomWeightedEdges(numberOfNodes, graph);
        return graph;
    }

    public static DirectedUnweightedGraph<Integer> createRandomDirectedUnweightedGraph(int numberOfNodes) {
        DirectedUnweightedGraph<Integer> graph = new DirectedUnweightedGraph<>();
        createRandomUnweightedEdges(numberOfNodes, graph);
        return graph;
    }

    public static UndirectedWeightedGraph<Integer, Integer> createRandomUndirectedWeightedGraph(int numberOfNodes) {
        UndirectedWeightedGraph<Integer, Integer> graph = new UndirectedWeightedGraph<>();
        createRandomWeightedEdges(numberOfNodes, graph);
        return graph;
    }

    public static UndirectedUnweightedGraph<Integer> createRandomUndirectedUnweightedGraph(int numberOfNodes) {
        UndirectedUnweightedGraph<Integer> graph = new UndirectedUnweightedGraph<>();
        createRandomUnweightedEdges(numberOfNodes, graph);
        return graph;
    }

    public static void createRandomUnweightedEdges(int numberOfNodes, IUnweightedGraph<Integer> graph) {
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if (i != j && !graph.isConnected(i, j) && NumberUtils.getRandomInt(0, 1) == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
    }

    public static void createRandomWeightedEdges(int numberOfNodes, IWeightedGraph<Integer, Integer> graph) {
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if (i != j && !graph.isConnected(i, j) && NumberUtils.getRandomInt(0, 1) == 1) {
                    graph.addEdge(i, j, NumberUtils.getRandomInt(10, 99));
                }
            }
        }
    }

    public static <Node> List<Node> getDfs(IGraph<Node> graph) {
        if (graph == null || graph.isEmpty()) {
            return Collections.emptyList();
        }
        List<Node> dfs = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        Node startNode = null;
        for (Node node : graph.getAllNodes()) {
            startNode = node;
            break;
        }
        stack.push(startNode);
        visited.add(startNode);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            dfs.add(pop);
            for (Node neighbour : graph.getNeighbours(pop)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        return dfs;
    }

    public static <Node> List<Node> getBfs(IGraph<Node> graph) {
        if (graph == null || graph.isEmpty()) {
            return Collections.emptyList();
        }
        List<Node> bfs = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        Node startNode = null;
        for (Node node : graph.getAllNodes()) {
            startNode = node;
            break;
        }
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            Node pop = queue.poll();
            bfs.add(pop);
            for (Node neighbour : graph.getNeighbours(pop)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }

    public static <Node> boolean hasCycle(IUndirectedGraph<Node> graph) {
        return hasCycle(graph, getRandomStartNode(graph), null, new HashSet<>());
    }

    private static <Node> boolean hasCycle(IUndirectedGraph<Node> graph, Node start, Node parent, Set<Node> visitedSet) {
        for (Node neighbour : graph.getNeighbours(start)) {
            if (!visitedSet.contains(neighbour)) {
                visitedSet.add(neighbour);
                return hasCycle(graph, neighbour, start, visitedSet);
            } else if (neighbour.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public static <Node> boolean hasCycle(IDirectedGraph<Node> graph) {
        return hasCycle(graph, getRandomStartNode(graph), new HashMap<>());
    }

    public static <Node> Node getRandomStartNode(IGraph<Node> graph) {
        Node start = null;
        for (Node node : graph.getAllNodes()) {
            start = node;
            break;
        }
        return start;
    }

    private static <Node> boolean hasCycle(IDirectedGraph<Node> graph, Node start, Map<Node, Integer> map) {
        if (!map.containsKey(start)) {
            map.put(start, 1);
            for (Node children : graph.getNeighbours(start)) {
                if ((!map.containsKey(children) && hasCycle(graph, children, map)) || map.get(children) == 1) {
                    return true;
                }
            }
            map.put(start, 2);
        }
        return false;
    }

}
