package com.leet.daysofcode.year2020.november.week2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ValidSquare {

    public static void main(String[] args) {
        int[][] p1s = {{0, 0}, {0, 0}};
        int[][] p2s = {{1, 1}, {0, 0}};
        int[][] p3s = {{1, 0}, {0, 0}};
        int[][] p4s = {{0, 1}, {0, 0}};
        boolean[] outputs = {true, false};
        ValidSquare validSquare = new ValidSquare();
        IntStream.range(0, p1s.length).forEachOrdered(i -> {
            System.out.println("Input : ps -> " + Arrays.toString(p1s[i]) + " p2 -> " + Arrays.toString(p2s[i]) + " p3 -> " + Arrays.toString(p3s[i]) + " p4 -> " + Arrays.toString(p4s[i]));
            System.out.println("Output : " + validSquare.validSquare(p1s[i], p2s[i], p3s[i], p4s[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] sides = {distance(p1, p2), distance(p2, p3), distance(p3, p4), distance(p4, p1), distance(p1, p3), distance(p4, p2)};
        Arrays.sort(sides);
        double side = sides[0];
        for (int i = 1; i < 4; i++) {
            if (side != sides[i] || side == 0) {
                return false;
            }
        }
        return sides[4] == sides[5];
    }

    private double max(double... num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        double max = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        return max;
    }

    private double distance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

}
