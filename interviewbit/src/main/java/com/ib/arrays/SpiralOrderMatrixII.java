package com.ib.arrays;

import com.ds.utils.ArrayUtils;

public class SpiralOrderMatrixII {

    public static void main(String... args) {
        SpiralOrderMatrixII spiralOrderMatrixII = new SpiralOrderMatrixII();
        ArrayUtils.printArr(spiralOrderMatrixII.generateMatrix(5));
    }

    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int counter = 1;
        int m = A;
        int n = A;
        int x = 0;
        int y = 0;
        while (counter <= (A * A)) {
            while (x < m) {
                result[y][x] = counter++;
                x++;
            }
            x--;
            y++;
            while (y < n) {
                result[y][x] = counter++;
                y++;
            }
            y--;
            x--;
            while (x >= A - m) {
                result[y][x] = counter++;
                x--;
            }
            x++;
            y--;
            while (y > A - n) {
                result[y][x] = counter++;
                y--;
            }
            y++;
            x++;
            m--;
            n--;
        }
        return result;
    }
}
