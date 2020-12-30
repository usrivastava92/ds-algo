package com.leet.daysofcode.december.week4;

import org.junit.Assert;
import java.util.*;
import java.util.stream.IntStream;

public class JumpGameIV {

    public static void main(String[] args) {
        int[][] inputs = {{6, 1, 9}, {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}};
        int[] outputs = {2, 3};
        JumpGameIV jumpGameIV = new JumpGameIV();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = jumpGameIV.minJumps(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < len; i++) {
            graph.computeIfAbsent(arr[i], v -> new HashSet<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int node = queue.poll();
                if (node == len - 1) {
                    return step;
                }
                for (int child : graph.getOrDefault(arr[node], Collections.emptySet())) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.add(child);
                    }
                }
                graph.remove(arr[node]);
                if (node + 1 < len && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    queue.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    queue.add(node - 1);
                }
            }
            step++;
        }
        return -1;
    }

}
