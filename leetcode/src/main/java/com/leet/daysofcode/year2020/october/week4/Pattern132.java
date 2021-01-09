package com.leet.daysofcode.year2020.october.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Pattern132 {

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4}, {3, 1, 4, 2}, {-1, 3, 2, 0}, {1, 3, 2}, {1, 0, 1, -4, -3}};
        boolean[] outputs = {false, true, true, true, false};
        Pattern132 pattern132 = new Pattern132();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + pattern132.find132pattern(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    //i < j < k and nums[i] < nums[k] < nums[j]
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> conditionFollowedMinHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer i : nums) {
            if (!minHeap.isEmpty() && minHeap.peek() < i) {
                conditionFollowedMinHeap.add(i);
            }
            if (!conditionFollowedMinHeap.isEmpty() && i < conditionFollowedMinHeap.peek() && !minHeap.isEmpty() && i > minHeap.peek()) {
                System.out.println(conditionFollowedMinHeap.peek() + " : " + i);
                return true;
            }
            minHeap.add(i);
        }
        return false;
    }

}
