package com.leet.daysofcode.may.week4;

import com.ds.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] A = new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}};
        int[][] B = new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}};
        ArrayUtils.printArr(intervalListIntersections.intervalIntersection(A, B));
    }


    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int aSize = A.length;
        int bSize = B.length;
        while (i < aSize && j < bSize) {
            int aStartTime = A[i][0];
            int aEndTime = A[i][1];
            int bStartTime = B[j][0];
            int bEndTime = B[j][1];
            if (bStartTime > aEndTime) {
                i++;
            } else if (aStartTime > bEndTime) {
                j++;
            } else {
                int[] overlap = new int[2];
                if (aStartTime < bStartTime) {
                    overlap[0] = bStartTime;
                    if (aEndTime < bEndTime) {
                        overlap[1] = aEndTime;
                        i++;
                    } else {
                        overlap[1] = bEndTime;
                        j++;
                    }
                } else {
                    overlap[0] = aStartTime;
                    if (aEndTime < bEndTime) {
                        i++;
                        overlap[1] = aEndTime;
                    } else {
                        j++;
                        overlap[1] = bEndTime;
                    }
                }
                list.add(overlap);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int x = 0, len = list.size(); x < len; x++) {
            ans[x] = list.get(x);
        }
        return ans;
    }

}
