package com.leet.ds.dp;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ReducingDishes {

    public static void main(String[] args) {
        int[][] inputs = {{-1, -8, 0, 5, -9}, {4, 3, 2}, {-1, -4, -5}, {-2, 5, -1, 0, 3, -3}, {34, -27, -49, -6, 65, 70, 72, -37, -57, 92, -72, 36, 6, -91, 18, 61, 77, -91, 5, 64, -16, 5, 20, -60, -94, -15, -23, -10, -61, 27, 89, 38, 46, 57, 33, 94, -79, 43, -67, -73, -39, 72, -52, 13, 65, -82, 26, 69, 67}};
        int[] outputs = {14, 20, 0, 35, 45811};
        ReducingDishes reducingDishes = new ReducingDishes();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = reducingDishes.maxSatisfaction(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int maxSatisfaction(int[] satisfaction) {
        if (satisfaction == null || satisfaction.length == 0) {
            return 0;
        }
        int len = satisfaction.length;
        Arrays.sort(satisfaction);
        if (satisfaction[len - 1] < 0) {
            return 0;
        }
        int res = 0, total = 0;
        for (int i = len - 1; i >= 0 && satisfaction[i] > -total; --i) {
            total += satisfaction[i];
            res += total;
        }
        return res;
    }

}
