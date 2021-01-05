package com.leet.daysofcode.may.week4;

import com.ds.utils.TreeUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][][] A = {{{0, 2}, {5, 10}, {13, 23}, {24, 25}}};
        int[][][] B = {{{1, 5}, {8, 12}, {15, 24}, {25, 26}}};
        int[][][] outputs = {{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}};
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        IntStream.range(0, A.length).forEachOrdered(i -> {
            System.out.println("Input : \nA : " + Arrays.deepToString(A[i]) + " \nB : " + Arrays.deepToString(B[i]));
            int[][] output = intervalListIntersections.intervalIntersection(A[i], B[i]);
            System.out.println("Output : " + Arrays.deepToString(output));
            Assert.assertArrayEquals(outputs[i], output);
        });
    }


    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[][]{};
        }
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int aLen = A.length;
        int bLen = B.length;
        while (i < aLen && j < bLen) {
            int aStart = A[i][0];
            int aEnd = A[i][1];
            int bStart = B[j][0];
            int bEnd = B[j][1];
            if (aStart > bEnd) {
                j++;
            } else if (bStart > aEnd) {
                i++;
            } else {
                int[] intersection = new int[2];
                intersection[0] = Math.max(aStart, bStart);
                if (aEnd < bEnd) {
                    intersection[1] = aEnd;
                    i++;
                } else {
                    intersection[1] = bEnd;
                    j++;
                }
                ans.add(intersection);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
