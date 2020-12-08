package com.leet.daysofcode.december.week1;

import com.ds.utils.ArrayUtils;

import java.util.stream.IntStream;

public class SpiralMatrixII {

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        IntStream.range(0, 6).forEachOrdered(i -> {
            System.out.println("Input : " + i);
            ArrayUtils.printArr(spiralMatrixII.generateMatrix(i));
        });
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{{}};
        }
        int[][] arr = new int[n][n];
        int max = n * n;
        int upperX = n;
        int upperY = n;
        int lowerX = 0;
        int lowerY = -1;
        int num = 1;
        int i = 0;
        int j = 0;
        int x = 0;
        while (num <= max) {
            System.out.println("("+i+","+j+")");
            if (x++ == 20) {
                break;
            }
            while (num <= max && j < upperY) {
                arr[i][j++] = num++;
            }
            upperY--;
            j--;
            i++;
            while (num <= max && i < upperX) {
                arr[i++][j] = num++;
            }
            upperX--;
            i--;
            j--;
            while (num <= max && j > lowerY) {
                arr[i][j--] = num++;
            }
            lowerY++;
            j++;
            i--;
            while (num <= max && i > lowerX) {
                arr[i--][j] = num++;
            }
            lowerX++;
            i++;
            j++;
        }
        return arr;
    }

}
