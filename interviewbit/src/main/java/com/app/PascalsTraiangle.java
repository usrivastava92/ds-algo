package com.app;

import java.util.ArrayList;

public class PascalsTraiangle {

    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int currentRowNum = 1; currentRowNum <= A; currentRowNum++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int elementIndex = 0; elementIndex < currentRowNum; elementIndex++) {
                if ((elementIndex - 1) < 0 || elementIndex == (currentRowNum - 1)) {
                    row.add(1);
                } else {
                    ArrayList<Integer> prevRow = result.get(currentRowNum - 2);
                    row.add(prevRow.get(elementIndex) + prevRow.get(elementIndex - 1));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static ArrayList<Integer> getNthRow(int A) {
        A++;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int currentRowNum = 1; currentRowNum <= A; currentRowNum++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int elementIndex = 0; elementIndex < currentRowNum; elementIndex++) {
                if ((elementIndex - 1) < 0 || elementIndex == (currentRowNum - 1)) {
                    row.add(1);
                } else {
                    ArrayList<Integer> prevRow = result.get(currentRowNum - 2);
                    row.add(prevRow.get(elementIndex) + prevRow.get(elementIndex - 1));
                }
            }
            result.add(row);
        }
        return result.get(A-1);
    }

}
