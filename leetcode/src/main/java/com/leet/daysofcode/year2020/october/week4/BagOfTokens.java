package com.leet.daysofcode.year2020.october.week4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BagOfTokens {

    public static void main(String[] args) {
        int[][] tokens = {{100}, {100, 200}, {100, 200, 300, 400}, {26}, {91, 4, 75, 70, 66, 71, 91, 64, 37, 54}};
        int[] ps = {50, 150, 200, 51, 20};
        int[] outputs = {0, 1, 2, 1, 2};
        BagOfTokens bagOfTokens = new BagOfTokens();
        IntStream.range(0, tokens.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(tokens[i]));
            System.out.println("Output : " + bagOfTokens.bagOfTokensScore(tokens[i], ps[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        int max = 0;
        int score = 0;
        int buyIndex = 0;
        int flipIndex = tokens.length - 1;
        while (buyIndex < tokens.length && buyIndex <= flipIndex && flipIndex > -1) {
            if (tokens[buyIndex] <= P) {
                P -= tokens[buyIndex++];
                score++;
                max = Math.max(max, score);
            } else if (score > 0) {
                P += tokens[flipIndex--];
                score--;
            } else {
                break;
            }
        }
        return max;
    }

}
