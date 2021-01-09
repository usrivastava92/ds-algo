package com.leet.daysofcode.year2020.may.week2;

public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}},
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}};
        int testCase = 1;
        CheckIfItIsAStraightLine checkIfItIsAStraightLine = new CheckIfItIsAStraightLine();
        System.out.println(checkIfItIsAStraightLine.checkStraightLine(inputs[testCase]));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 2) {
            return true;
        }
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        int numerator = (point1[1] - point2[1]);
        int denominator = (point1[0] - point2[0]);
        System.out.println(numerator + " : " + denominator);
        if (numerator != 0 && denominator == 0) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != 0) {
                    return false;
                }
            }
        } else {
            float slope = numerator / (denominator == 0 ? 1 : denominator);
            System.out.println("slope : " + slope);
            for (int i = 2; i < coordinates.length; i++) {
                int[] point = coordinates[i];
                System.out.println("(" + point[1] + " - " + point1[1] + ") : " + (point[1] - point1[1]) + " | " + "(" + point[0] + " - " + point1[0] + ") : " + (point[0] - point1[0]));
                if ((point[1] - point1[1]) != (slope * (point[0] - point1[0]))) {
                    return false;
                }
            }
        }
        return true;
    }


}
