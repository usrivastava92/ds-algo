package com.leet.daysofcode.october.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class StoneGameIV {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6, 7};
        boolean[] outputs = {true, false, true, true, false, true, false};
        StoneGameIV stoneGameIV = new StoneGameIV();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            boolean output = stoneGameIV.winnerSquareGame(inputs[i]);
            System.out.println("Output : " + output);
            System.out.println("Expected : " + outputs[i]);
        });
    }

    private Map<Integer, Boolean> globalDp = new HashMap<>();

    {
        globalDp.put(1, true);
    }

    public boolean winnerSquareGame(int n) {
        if (n <= 0) {
            return false;
        }
        for (int i = 2; i <= n; i++) {
            if (!globalDp.containsKey(i)) {
                boolean win = false;
                for (int j = 1; j * j <= i; j++) {
                    int sqr = j * j;
                    if (sqr == i || !globalDp.get(i - sqr)) {
                        win = true;
                        break;
                    }
                }
                globalDp.put(i, win);
            }
        }
        return globalDp.get(n);
    }

}
