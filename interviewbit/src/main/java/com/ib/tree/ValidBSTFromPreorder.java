package com.ib.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class ValidBSTFromPreorder {

    public static void main(String[] args) {
        int[][] inputs = {{}, {7, 7, 10, 10, 9, 5, 2, 8}};
        int[] outputs = {0, 1};
        ValidBSTFromPreorder validBSTFromPreorder = new ValidBSTFromPreorder();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + validBSTFromPreorder.solve(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int solve(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int a = 0, b = 1, c = 2;
        if (A.length <= 2)
            return 1;
        while (c < A.length) {
            if (A[a] < A[b] && A[b] > A[c] && A[c] < A[a])
                return 0;
            a++;
            b++;
            c++;
        }
        return 1;
    }

}
