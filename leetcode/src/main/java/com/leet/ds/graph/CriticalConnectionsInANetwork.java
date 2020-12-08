package com.leet.ds.graph;

import java.util.*;

public class CriticalConnectionsInANetwork {

    public static void main(String[] args) {

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections == null || connections.isEmpty() || n <= 1) {
            return Collections.emptyList();
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (List<Integer> edge : connections) {
            int from = edge.get(0);
            int to = edge.get(1);
            Set<Integer> set1 = adj.getOrDefault(from, new HashSet<>());
            Set<Integer> set2 = adj.getOrDefault(to, new HashSet<>());
            set1.add(to);
            set2.add(from);
            adj.put(from, set1);
            adj.put(to, set2);
        }
        int[] timer = new int[1];
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> lows = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs(ans, 0, -1, timer, lows, visited, adj);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int node, int parent, int[] timer, Map<Integer, Integer> lows, Set<Integer> visited, Map<Integer, Set<Integer>> adj) {
        visited.add(node);
        lows.put(node, timer[0]++);
        for (int child : adj.getOrDefault(node, Collections.emptySet())) {
            if (!visited.contains(child)) {
                dfs(ans, child, node, timer, lows, visited, adj);
                lows.put(node, Math.min(lows.get(node), lows.get(child)));
                if (lows.get(child) > lows.get(node)) {
                    ans.add(Arrays.asList(child, node));
                }
            } else if (child != parent) {
                lows.put(node, Math.min(lows.get(node), lows.get(child)));
            }
        }
    }

    public List<List<Integer>> criticalConnectionsCorrect(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int[] timer = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        return results;
    }


    public void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int[] timer, boolean[] visited, List<List<Integer>> results, int[] lows) {
        visited[node] = true;
        lows[node] = timer[0]++;
        int currentTimeStamp = lows[node];
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            }
            if (!visited[child]) {
                criticalConnectionsUtil(graph, node, child, timer, visited, results, lows);
            }
            lows[node] = Math.min(lows[node], lows[child]);
            if (currentTimeStamp < lows[child]) {
                results.add(Arrays.asList(node, child));
            }
        }
    }

}
