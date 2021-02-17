package com.leet.daysofcode.year2021.february.week2;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;
import java.util.stream.IntStream;

public class IsGraphBipartite {

    public static void main(String[] args) {
        int[][][] inputs = {{{3}, {2, 4}, {1}, {0, 4}, {1, 3}}, {{1, 3}, {0, 2}, {1, 3}, {0, 2}}, {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}};
        boolean[] outputs = {true, true, false};
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            boolean output = isGraphBipartite.isBipartite(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }


    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for (int adjacent : graph[node])
            if (!validColor(graph, colors, -color, adjacent))
                return false;
        return true;
    }

}
