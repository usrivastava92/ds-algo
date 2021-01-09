package com.leet.daysofcode.year2020.october.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ChampagneTower {

    public static void main(String[] args) {
        int[] poured = {1, 2, 100000009};
        int[] query_row = {1, 1, 33};
        int[] query_glass = {1, 1, 17};
        double[] outputs = {0.00000, 0.50000, 1.00000};
        ChampagneTower champagneTower = new ChampagneTower();
        IntStream.range(0, poured.length).forEachOrdered(i -> {
            System.out.println("Input : poured -> " + poured[i] + " query_row -> " + query_row[i] + " query_glass -> " + query_glass[i]);
            System.out.println("Output : " + champagneTower.champagneTower(poured[i], query_row[i], query_glass[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured <= 0) {
            return 0;
        }
        List<List<Double>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(poured * 1d));
        for (int rowIndex = 1; rowIndex <= query_row; rowIndex++) {
            List<Double> row = new ArrayList<>();
            for (int glassIndex = 0; glassIndex <= rowIndex; glassIndex++) {
                List<Double> topRow = dp.get(rowIndex - 1);
                double valueInGlassTopLeft = glassIndex - 1 > -1 ? topRow.get(glassIndex - 1) : 0;
                double valueInGlassTopRight = glassIndex < topRow.size() ? topRow.get(glassIndex) : 0;
                double valueInCurrentGlass = Math.max((valueInGlassTopLeft - 1) / 2, 0) + Math.max((valueInGlassTopRight - 1) / 2, 0);
                row.add(valueInCurrentGlass);
            }
            dp.add(row);
        }
        return Math.min(1, dp.get(query_row).get(query_glass));
    }

    private <T> void printPyramid(List<List<T>> list) {
        for (List<T> row : list) {
            System.out.println(row);
        }
    }

}
