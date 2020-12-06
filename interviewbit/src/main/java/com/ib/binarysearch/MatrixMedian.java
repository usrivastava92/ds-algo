package com.ib.binarysearch;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MatrixMedian {

    public static void main(String[] args) {
        int[][][] As = {{{1, 3, 5}, {2, 6, 9}, {3, 6, 9}}, {{5, 17, 100}}};
        int[] outputs = {5, 17};
        MatrixMedian matrixMedian = new MatrixMedian();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input -> ");
            ArrayUtils.printArr(As[i]);
            int output = matrixMedian.findMedian(As[i]);
            System.out.println("output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int findMedian(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> A[i[0]][i[1]]));
        for (int i = 0; i < A.length; i++) {
            minHeap.add(new int[]{i, 0});
        }
        int totalNumbers = n * m;
        boolean totalEven = totalNumbers % 2 == 0;
        int max = (totalNumbers / 2) + 1;
        // 9 -> 1 2 3 4 5 6 7 8 9
        // 4 -> 1 2 3 4
        int last = 0, curr = 0;
        for (int i = 1; i <= max; i++) {
            last = curr;
            int[] poll = minHeap.poll();
            assert poll != null;
            curr = A[poll[0]][poll[1]];
            poll[1]++;
            if (poll[1] < m) {
                minHeap.add(poll);
            }
        }
        if (totalEven) {
            return (last + curr) / 2;
        }
        return curr;
    }

}
