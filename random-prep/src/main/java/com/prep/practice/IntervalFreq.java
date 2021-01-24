package com.prep.practice;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class IntervalFreq {

    public static void main(String[] args) {
        int[][][] inputs = {{{0, 3}, {1, 4}, {2, 7}}};
        String[][] outputs = {{"[0, 1, 1]", "[1, 2, 2]", "[2, 3, 3]", "[3, 4, 2]", "[4, 7, 1]"}};
        IntervalFreq intervalFreq = new IntervalFreq();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input -> " + Arrays.deepToString(inputs[i]));
            List<String> output = intervalFreq.getFreq(inputs[i]);
            System.out.println("Output -> " + output);
            Assert.assertEquals(Arrays.asList(outputs[i]), output);
        });
    }

    public List<String> getFreq(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return Collections.emptyList();
        }
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int currFreq = 1;
        int startIndex = 1;
        int endIndex = 0;
        int lastStart = starts[0];
        List<String> ans = new ArrayList<>();
        while (startIndex < len && endIndex < len) {
            if (starts[startIndex] < ends[endIndex]) {
                ans.add(getString(lastStart, starts[startIndex], currFreq));
                lastStart = starts[startIndex];
                currFreq++;
                startIndex++;
            } else if (starts[startIndex] > ends[endIndex]) {
                ans.add(getString(lastStart, ends[endIndex], currFreq));
                lastStart = ends[endIndex];
                currFreq--;
                endIndex++;
            } else {
                startIndex++;
                endIndex++;
            }
        }
        while (endIndex < len) {
            ans.add(getString(lastStart, ends[endIndex], currFreq));
            lastStart = ends[endIndex];
            currFreq--;
            endIndex++;
        }
        return ans;
    }

    private String getString(int i, int j, int k) {
        return "[" + i + ", " + j + ", " + k + "]";
    }


}
