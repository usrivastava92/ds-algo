package com.ib.graphs;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BlackShapes {

    public static void main(String[] args) {
        String[][] inputs = {{"OOOXOOO", "OOXXOXO", "OXOOOXO"}};
        int[] outputs = {3};
        BlackShapes blackShapes = new BlackShapes();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = blackShapes.black(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int black(String[] A) {
        if (A == null || A.length == 0 || A[0].length() == 0) {
            return 0;
        }
        char[][] chars = new char[A.length][];
        for (int i = 0; i < A.length; i++) {
            chars[i] = A[i].toCharArray();
        }
        ArrayUtils.printArr(chars);
        int n = A.length;
        int m = chars[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'X') {
                    ans++;
                    dfs(chars, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] chars, int i, int j) {
        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length || chars[i][j] == 'O') {
            return;
        }
        chars[i][j] = 'O';
        dfs(chars, i + 1, j);
        dfs(chars, i - 1, j);
        dfs(chars, i, j + 1);
        dfs(chars, i, j - 1);
    }


}
