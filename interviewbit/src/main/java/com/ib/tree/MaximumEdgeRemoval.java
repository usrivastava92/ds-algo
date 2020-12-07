package com.ib.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MaximumEdgeRemoval {

    public static void main(String[] args) {
        int[] As = {6, 2};
        int[][][] Bs = {{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {4, 6}}, {{1, 2}}};
        MaximumEdgeRemoval maximumEdgeRemoval = new MaximumEdgeRemoval();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.printf("Input -> A : %s, B : %s \n", As[i], Arrays.deepToString(Bs[i]));
            System.out.println("Output : " + maximumEdgeRemoval.solve(As[i], Bs[i]));
        });
    }

    public int solve(int A, int[][] B) {
        boolean[] visited = new boolean[A + 1];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : B) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> set1 = adj.getOrDefault(from, new HashSet<>());
            Set<Integer> set2 = adj.getOrDefault(to, new HashSet<>());
            set1.add(to);
            set2.add(from);
            adj.put(from, set1);
            adj.put(to, set2);
        }
        Int res = new Int(0);
        new AtomicInteger().incrementAndGet();
        visited[1] = true;
        dfs(1, visited, adj, res);
        return res.num;
    }

    int dfs(int node, boolean[] visited, Map<Integer, Set<Integer>> adj, Int atomicInteger) {
        int tree_count = 0;
        for (int child : adj.getOrDefault(node, Collections.emptySet())) {
            if (!visited[child]) {
                visited[child] = true;
                int subtree_count = dfs(child, visited, adj, atomicInteger);
                if (subtree_count % 2 == 0) {
                    atomicInteger.num++;
                } else {
                    tree_count += subtree_count;
                }
            }
        }
        return tree_count + 1;
    }

    private static final class Int {
        int num;

        public Int(int num) {
            this.num = num;
        }
    }

}
