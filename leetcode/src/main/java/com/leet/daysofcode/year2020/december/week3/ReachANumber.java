package com.leet.daysofcode.year2020.december.week3;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class ReachANumber {


    public static void main(String[] args) {
        int[] inputs = {1, 3, 2, 9};
        int[] outputs = {1, 2, 3, 5};
        ReachANumber reachANumber = new ReachANumber();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            int output = reachANumber.reachNumber(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int reachNumber(int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                int poll = queue.poll();
                if (poll == target) {
                    return level;
                }
                int temp = poll + (level + 1);
                if (Integer.MAX_VALUE - level >= poll) {
                    queue.add(temp);
                }
                temp = poll - (level + 1);
                if (Integer.MIN_VALUE + level <= poll) {
                    queue.add(temp);
                }
            }
            level++;
        }
        return -1;
    }

}
