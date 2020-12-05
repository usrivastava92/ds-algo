package com.ds.graph;

import com.ds.utils.NumberUtils;

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
            for (WeightedEdge<Node, Integer> neighbourEntry : graph.getNeighbouringWeightedEdges(nearest)) {
                Node neighbour = neighbourEntry.getTo();
                Integer weight = neighbourEntry.getWeight();
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
     *
     * @param graph
     * @param <Node>
     * @return weight of min spanning tree
     */
    public static <Node> int applyKruskal(IWeightedGraph<Node, Integer> graph) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("Graph can't be null/empty");
        }
        Set<Node> visited = new HashSet<>();
        int minWeight = 0;
        PriorityQueue<WeightedEdge<Node, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedEdge::getWeight));
        minHeap.addAll(graph.getAllWeightedEdges());
        while (!minHeap.isEmpty()) {
            WeightedEdge<Node, Integer> minEdge = minHeap.poll();
            Node from = minEdge.getFrom();
            Node to = minEdge.getTo();
            Integer weight = minEdge.getWeight();
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
     *
     * @param graph
     * @param <Node>
     * @return weight of min spanning tree
     */
    public static <Node> int applyPrims(IWeightedGraph<Node, Integer> graph) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("Graph can't be null/empty");
        }
        int minWeight = 0;
        WeightedEdge<Node, Integer> minWeightEdge = null;
        for (WeightedEdge<Node, Integer> edge : graph.getAllWeightedEdges()) {
            if (minWeightEdge == null) {
                minWeightEdge = edge;
            } else if (edge.getWeight() < minWeightEdge.getWeight()) {
                minWeightEdge = edge;
            }
        }
        assert minWeightEdge != null : "Unexpected behaviour, minWeightEdge is null";
        Set<Node> visited = new HashSet<>();
        PriorityQueue<WeightedEdge<Node, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedEdge::getWeight));
        minHeap.add(minWeightEdge);
        while (!minHeap.isEmpty()) {
            WeightedEdge<Node, Integer> minEdge = minHeap.poll();
            if (!visited.contains(minEdge.getFrom()) || !visited.contains(minEdge.getTo())) {
                minWeight += minEdge.getWeight();
                if (!visited.contains(minEdge.getFrom())) {
                    visited.add(minEdge.getFrom());
                    minHeap.addAll(graph.getNeighbouringWeightedEdges(minEdge.getFrom()));
                }
                if (!visited.contains(minEdge.getTo())) {
                    visited.add(minEdge.getTo());
                    minHeap.addAll(graph.getNeighbouringWeightedEdges(minEdge.getTo()));
                }
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
        return hasCycle(graph, getRandomNode(graph), null, new HashSet<>());
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
        return hasCycle(graph, getRandomNode(graph), new HashMap<>());
    }

    public static <Node> Node getRandomNode(IGraph<Node> graph) {
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

    public static <Node> List<Node> applyTopologicalSort(IDirectedGraph<Node> graph) {
        if (graph == null) {
            return Collections.emptyList();
        }
        Map<Node, Integer> inDegree = new HashMap<>();
        Node startNode = null;
        for (Edge<Node> edge : graph.getAllEdges()) {
            inDegree.put(edge.getFrom(), inDegree.getOrDefault(edge.getFrom(), 0));
            inDegree.put(edge.getTo(), inDegree.getOrDefault(edge.getTo(), 0) + 1);
            if (startNode == null) {
                startNode = edge.getFrom();
            } else {
                if (inDegree.get(edge.getFrom()) < inDegree.get(startNode)) {
                    startNode = edge.getFrom();
                }
            }
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        topologicalHelper(visited, startNode, graph, stack);

        Set<Node> nodes = graph.getAllNodes();
        nodes.remove(startNode);
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                topologicalHelper(visited, node, graph, stack);
            }
        }

        List<Node> topologicalSort = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalSort.add(stack.pop());
        }

        return topologicalSort;
    }

    private static <Node> void topologicalHelper(Set<Node> visited, Node node, final IDirectedGraph<Node> graph, Stack<Node> topologicalStack) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        graph.getNeighbours(node).forEach(neighbour -> topologicalHelper(visited, neighbour, graph, topologicalStack));
        topologicalStack.add(node);
    }

    public static void union(int[] parents, int i, int j) {
        if (parents == null || i == j) {
            return;
        }
        int parentI = find(parents, i);
        int parentJ = find(parents, j);
        if (parentI == parentJ) {
            return;
        }
        parents[parentI] = parentJ;
    }

    public static void union(int[] parents, int i, int j, int[] ranks) {
        if (parents == null || i == j) {
            return;
        }
        int parentI = find(parents, i);
        int parentJ = find(parents, j);
        if (parentI == parentJ) {
            return;
        }
        if (ranks[parentI] > ranks[parentJ]) {
            parents[parentJ] = parentI;
            ranks[parentI] = ranks[parentI] + ranks[parentJ];
        } else {
            parents[parentI] = parentJ;
            ranks[parentJ] = ranks[parentI] + ranks[parentJ];
        }
    }

    public static int find(int[] parents, int node) {
        if (parents == null) {
            throw new IllegalArgumentException("parents array can't be null");
        }
        while (parents[node] != node) {
            node = parents[node];
        }
        return node;
    }

    public static <Node> void union(Map<Node, Node> parents, Node i, Node j) {
        if (parents == null || i.equals(j)) {
            return;
        }
        Node parentI = find(parents, i);
        Node parentJ = find(parents, j);
        if (parentI.equals(parentJ)) {
            return;
        }
        parents.put(parentI, parentJ);
    }

    public static <Node> void union(Map<Node, Node> parents, Node i, Node j, Map<Node, Integer> rankMap) {
        if (parents == null || i.equals(j)) {
            return;
        }
        Node parentI = find(parents, i);
        Node parentJ = find(parents, j);
        if (parentI.equals(parentJ)) {
            return;
        }
        if (rankMap.get(parentI) > rankMap.get(parentJ)) {
            parents.put(parentJ, parentI);
            rankMap.put(parentI, rankMap.get(parentI) + rankMap.get(parentJ));
        } else {
            parents.put(parentI, parentJ);
            rankMap.put(parentJ, rankMap.get(parentJ) + rankMap.get(parentI));
        }
    }

    public static <Node> Node find(Map<Node, Node> parents, Node node) {
        if (parents == null || node == null) {
            throw new IllegalArgumentException("parents map/node can't be null");
        }
        while (!parents.get(node).equals(node)) {
            node = parents.get(node);
        }
        return node;
    }

}
