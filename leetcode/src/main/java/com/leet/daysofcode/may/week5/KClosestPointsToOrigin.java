package com.leet.daysofcode.may.week5;

import com.ds.utils.ArrayUtils;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {


    public static void main(String[] args) {
        int[][][] points = {{{1, 3}, {-2, 2}}, {{3, 3}, {5, -1}, {-2, 4}}};
        int[] ks = {1, 2};
        int[][][] outputs = {{{-2, 2}}, {{3, 3}, {-2, 4}}};
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        for (int i = 0; i < ks.length; i++) {
            System.out.println("Input : points -> " + ArrayUtils.toString(points[i]) + " , k -> " + ks[i]);
            System.out.println("Output : " + ArrayUtils.toString(kClosestPointsToOrigin.kClosest(points[i], ks[i])));
            System.out.println("Expected : " + ArrayUtils.toString(outputs[i]));
            System.out.println("####################################################");
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K == 0) {
            return new int[2][0];
        }
        if (K >= points.length) {
            return points;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i, j) -> {
            double distA = getDist(i);
            double distB = getDist(j);
            return Double.compare(distB, distA);
        });
        int i = 0;
        while (i < K) {
            maxHeap.add(points[i++]);
        }
        for (int len = points.length; i < len; i++) {
            int[] point = points[i];
            double now = getDist(point);
            double maxDist = getDist(maxHeap.peek());
            if (Double.compare(maxDist, now) > 0) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }
        int[][] ans = new int[K][2];
        i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }

    public double getDist(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

}
