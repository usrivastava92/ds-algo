package com.leet.daysofcode.april.week2;

public class PerformStringShifts {

    public static void main(String[] args) {
        PerformStringShifts performStringShifts = new PerformStringShifts();
        String s = "abcdefg";
        int[][] shift = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{0, 2}, new int[]{1, 3}};
        System.out.println(performStringShifts.stringShift(s, shift));
    }

    public String stringShift(String s, int[][] shift) {
        for (int[] sh : shift) {
            if (sh[0] == 0) {
                s = leftShift(s, sh[1]);
            } else {
                s = rightShift(s, sh[1]);
            }
        }
        return s;
    }

    private String rightShift(String str, int place) {
        place = place % str.length();
        int temp = str.length() - place;
        return str.substring(temp) + str.substring(0, temp);
    }

    private String leftShift(String str, int place) {
        place = place % str.length();
        return str.substring(place) + str.substring(0, place);
    }
}
