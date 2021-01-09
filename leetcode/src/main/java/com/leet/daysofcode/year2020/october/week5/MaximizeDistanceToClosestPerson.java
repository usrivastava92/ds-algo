package com.leet.daysofcode.year2020.october.week5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        int[][] inputs = {{1, 0, 0, 0, 1, 0, 1}, {1, 0, 0, 0}, {0, 1}, {0, 0, 0, 0, 0}};
        int[] outputs = {2, 3, 1, 5};
        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = new MaximizeDistanceToClosestPerson();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + maximizeDistanceToClosestPerson.maxDistToClosest(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int lastPersonIndex = -1;
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                int seatsInBtn = i - lastPersonIndex - 1;
                if (lastPersonIndex == -1) {
                    if (i != 0) {
                        maxDist = i;
                    }
                } else {
                    int maxPossibleDist = (seatsInBtn % 2 == 0 ? seatsInBtn : seatsInBtn + 1) / 2;
                    if (maxDist < maxPossibleDist) {
                        maxDist = maxPossibleDist;
                    }
                }
                lastPersonIndex = i;
            }
        }
        int maxPossibleDist = seats.length - lastPersonIndex - 1;
        if (maxDist < maxPossibleDist) {
            maxDist = maxPossibleDist;
        }
        return maxDist;
    }

}
