package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval>[] inputs = new ArrayList[]{new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18))), new ArrayList<>(Arrays.asList(new Interval(1, 10), new Interval(2, 9), new Interval(3, 8), new Interval(4, 7), new Interval(5, 6), new Interval(6, 6)))};
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("output : " + mergeOverlappingIntervals.merge(inputs[i]));
        });
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return ans;
        }
        intervals.sort((a, b) -> {
            int startComp = Integer.compare(a.start, b.start);
            if (startComp == 0) {
                return Integer.compare(a.end, b.end);
            }
            return startComp;
        });
        int len = intervals.size();
        ans.add(intervals.get(0));
        for (int i = 1; i < len; i++) {
            Interval curr = intervals.get(i);
            Interval last = ans.get(ans.size() - 1);
            if (curr.start <= last.end) {
                last.end = Math.max(curr.end, last.end);
            } else {
                ans.add(curr);
            }
        }
        return ans;
    }


    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + ']';
        }
    }
}
