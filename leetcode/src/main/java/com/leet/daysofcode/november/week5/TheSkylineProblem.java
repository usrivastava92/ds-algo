package com.leet.daysofcode.november.week5;

import com.ds.utils.ArrayUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;

import java.util.*;

public class TheSkylineProblem {

    public static void main(String[] args) {
        int[][] input = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] expected = {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};
        System.out.println("Input : " + Arrays.deepToString(input));
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        List<List<Integer>> output = theSkylineProblem.getSkyline(input);
        System.out.println("Output : " + output);
        Assert.assertEquals(ArrayUtils.asList(expected), output);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return Collections.emptyList();
        }
        int len = buildings.length;
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        while (i < len) {
            int[] building = buildings[i];
            int currStart = building[0];
            int currEnd = building[1];
            int currHeight = building[2];
            if (maxHeap.isEmpty()) {
                maxHeap.add(building);
                if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != currHeight) {
                    ans.add(Arrays.asList(currStart, currHeight));
                }
                i++;
            } else {
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= currStart) {
                    maxHeap.poll();
                }
                if (!maxHeap.isEmpty()) {
                    maxHeap.add(building);
                    if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != maxHeap.peek()[2]) {
                        ans.add(Arrays.asList(currStart, maxHeap.peek()[2]));
                    }
                    i++;
                }
            }
        }
        return ans;
    }


}
