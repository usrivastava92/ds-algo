package com.leet.ds.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[][] heights = {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {1, 1}, {4, 3, 2, 1, 4}, {1, 2, 1}};
        int[] outputs = {49, 1, 16, 2};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        IntStream.range(0, heights.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(heights[i]));
            System.out.println("Output : " + containerWithMostWater.maxArea(heights[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxWater = 0;
        while (leftIndex < rightIndex) {
            maxWater = Math.max(maxWater, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxWater;
    }

}
