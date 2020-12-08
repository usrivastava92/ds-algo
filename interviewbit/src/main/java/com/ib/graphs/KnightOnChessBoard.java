package com.ib.graphs;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class KnightOnChessBoard {

    public static void main(String[] args) {
        int[] As = {8};
        int[] Bs = {8};
        int[] Cs = {1};
        int[] Ds = {1};
        int[] Es = {8};
        int[] Fs = {8};
        int[] outputs = {6};
        KnightOnChessBoard knightOnChessBoard = new KnightOnChessBoard();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.printf("Input -> A : %s ,B : %s ,C : %s ,D : %s ,E : %s ,F : %s\n", As[i], Bs[i], Cs[i], Ds[i], Es[i], Fs[i]);
            int output = knightOnChessBoard.knight(As[i], Bs[i], Cs[i], Ds[i], Es[i], Fs[i]);
            System.out.println("output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    private final int[][] steps = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public int knight(int A, int B, int C, int D, int E, int F) {
        return applyDijkstra(A, B, C, D).getOrDefault(getKey(E, F), -1);
    }

    private Map<String, Integer> applyDijkstra(int A, int B, int C, int D) {
        String start = getKey(C, D);
        Map<String, Integer> minMap = new HashMap<>();
        minMap.put(start, 0);
        PriorityQueue<String> minHeap = new PriorityQueue<>(Comparator.comparingInt(minMap::get));
        minHeap.add(start);
        while (!minHeap.isEmpty()) {
            String minDistNode = minHeap.poll();
            int currentWeight = minMap.get(minDistNode);
            for (int[] step : steps) {
                String[] tokens = minDistNode.split(",");
                int i = Integer.parseInt(tokens[0]);
                int j = Integer.parseInt(tokens[1]);
                int toX = i + step[0];
                int toY = j + step[1];
                if (isValidCell(toX, toY, A, B)) {
                    String neighbour = getKey(toX, toY);
                    boolean isVisited = minMap.containsKey(neighbour);
                    int minDist;
                    if (isVisited) {
                        minDist = Math.min(minMap.get(neighbour), currentWeight + 1);
                    } else {
                        minDist = currentWeight + 1;
                    }
                    minMap.put(neighbour, minDist);
                    if (!isVisited) {
                        minHeap.add(neighbour);
                    }
                }
            }
        }
        return minMap;
    }

    private boolean isValidCell(int toX, int toY, int a, int b) {
        return toX > 0 && toY > 0 && toX <= a && toY <= b;
    }

    private String getKey(int x, int y) {
        return x + "," + y;
    }

}
