package com.leet.daysofcode.october.week3;

import java.util.*;
import java.util.stream.IntStream;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[][] inputs = {{5, 10, -5}, {8, -8}, {10, 2, -5}, {-2, -1, 1, 2}};
        int[][] outputs = {{5, 10}, {}, {10}, {-2, -1, 1, 2}};
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + Arrays.toString(asteroidCollision.asteroidCollision(inputs[i])));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }
        Deque<Integer> positiveStack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                positiveStack.push(asteroid);
            } else {
                if (positiveStack.isEmpty()) {
                    output.add(asteroid);
                } else {
                    boolean asteroidStillExist = true;
                    while (!positiveStack.isEmpty() && positiveStack.peek() <= Math.abs(asteroid)) {
                        int pop = positiveStack.pop();
                        if (pop == Math.abs(asteroid)) {
                            asteroidStillExist = false;
                            break;
                        }
                    }
                    if (asteroidStillExist && positiveStack.isEmpty()) {
                        output.add(asteroid);
                    }
                }
            }
        }
        while (!positiveStack.isEmpty()) {
            output.add(positiveStack.removeLast());
        }
        return output.stream().mapToInt(num -> num).toArray();
    }

}
