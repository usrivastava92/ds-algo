package com.prep.practice;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        String[][] logs = {{"0:start:0", "1:start:2", "1:end:5", "0:end:6"}};
        int[] ns = {2};
        int[][] outputs = {{3, 4}};
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = new ExclusiveTimeOfFunctions();
        IntStream.range(0, logs.length).forEachOrdered(i -> {
            System.out.println("Input : n -> " + ns[i] + " logs -> " + Arrays.toString(logs[i]));
            int[] output = exclusiveTimeOfFunctions.exclusiveTime(ns[i], Arrays.asList(logs[i]));
            System.out.println("Output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }

    private static final String START = "start";

    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.isEmpty()) {
            return new int[]{};
        }
        int[] ans = new int[n];
        Stack<String[]> stack = new Stack<>();
        for (String log : logs) {
            String[] tokens = log.split("[:]");
            String id = tokens[0];
            String command = tokens[1];
            String time = tokens[2];
            if (command.equals(START)) {
                if (!stack.isEmpty()) {
                    ans[Integer.parseInt(stack.peek()[0])] += Integer.parseInt(time) - Integer.parseInt(stack.peek()[2]);
                    stack.peek()[2] = String.valueOf(Integer.parseInt(time) - 1);
                }
                stack.push(tokens);
            } else {
                ans[Integer.parseInt(id)] += (Integer.parseInt(time) - Integer.parseInt(stack.pop()[2])) + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[2] = String.valueOf(Integer.parseInt(time) + 1);
                }
            }
        }
        return ans;
    }

}
