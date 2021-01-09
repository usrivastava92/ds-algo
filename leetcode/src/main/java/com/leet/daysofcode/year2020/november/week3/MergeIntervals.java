package com.leet.daysofcode.year2020.november.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][][] inputs = {{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, {{1, 4}, {4, 5}}, {}, {{4, 5}}, {{1, 4}, {2, 3}}, {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}};
        int[][][] outputs = {{{1, 6}, {8, 10}, {15, 18}}, {{1, 5}}, {}, {{4, 5}}, {{1, 4}}, {{1, 10}}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.deepToString(inputs[i]));
            System.out.println("Output : " + Arrays.deepToString(mergeIntervals.merge(inputs[i])));
            System.out.println("Expected : " + Arrays.deepToString(outputs[i]));
        });
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int intervalStart = intervals[0][0];
        int intervalEnd = intervals[0][1];
        int i;
        int len = intervals.length - 1;
        for (i = 0; i < len; i++) {
            int thisIntervalEnd = intervals[i][1];
            int nextIntervalStart = intervals[i + 1][0];
            int nextIntervalEnd = intervals[i + 1][1];
            intervalEnd = Math.max(intervalEnd, thisIntervalEnd);
            if (nextIntervalStart > intervalEnd) {
                ans.add(new int[]{intervalStart, intervalEnd});
                intervalEnd = nextIntervalEnd;
                intervalStart = nextIntervalStart;
            }
        }
        ans.add(new int[]{intervalStart, Math.max(intervalEnd, intervals[i][1])});
        int[][] ansArr = new int[ans.size()][2];
        for (i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }


}
