package com.leet.daysofcode.july.week1;

import java.nio.file.Files;
import java.util.*;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        int[][] cells = {{0, 1, 0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0}};
        int[] Ns = {7, 1000000000, 27};
        int[][] outputs = {{0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}};
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        for (int i = 0, len = cells.length; i < len; i++) {
            System.out.println("Input : cells -> " + Arrays.toString(cells[i]) + ", n -> " + Ns[i]);
            System.out.println("Output : " + Arrays.toString(prisonCellsAfterNDays.prisonAfterNDays(cells[i], Ns[i])));
            System.out.println("Excepted : " + Arrays.toString(outputs[i]));
        }
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N <= 0) {
            return cells;
        }
        Map<String, Integer> map = new HashMap<>();
        int[] cellsToday = cells;
        int[] cellsTomorrow = cells;
        for (int i = 0; i <= N; i++) {
            cellsToday = cellsTomorrow;
            cellsTomorrow = process(cellsToday);
            String cellsTodayString = Arrays.toString(cellsToday);
            String cellsTomorrowString = Arrays.toString(cellsTomorrow);
            map.put(cellsTodayString, i);
            if (map.containsKey(cellsTomorrowString)) {
                int cycleDays = i - map.get(cellsTomorrowString) + 1;
                int daysLeft = N - i;
                int mod = daysLeft % cycleDays;
                if (mod == 0) {
                    return cellsToday;
                } else {
                    i = N - mod;
                }
                map.clear();
            }
        }
        return cellsToday;
    }

    private int[] process(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0, len = arr.length; i < len; i++) {
            int before = i - 1;
            int after = i + 1;
            if (before < 0 || after >= len || arr[before] != arr[after]) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
