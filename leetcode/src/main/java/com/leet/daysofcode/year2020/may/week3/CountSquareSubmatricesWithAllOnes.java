package com.leet.daysofcode.year2020.may.week3;

import com.ds.utils.ArrayUtils;

public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        int[][][] matrixes = {{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}};
        CountSquareSubmatricesWithAllOnes countSquareSubmatricesWithAllOnes = new CountSquareSubmatricesWithAllOnes();
        for (int i = 0; i < matrixes.length; i++) {
            System.out.println("Input : ");
            ArrayUtils.printArr(matrixes[i]);
            System.out.println("Output : " + countSquareSubmatricesWithAllOnes.countSquares(matrixes[i]));
        }
    }

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int squares = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 1) {
                    int top = i - 1 > -1 ? matrix[i - 1][j] : 0;
                    int left = j - 1 > -1 ? matrix[i][j - 1] : 0;
                    int diag = i - 1 > -1 && j - 1 > -1 ? matrix[i - 1][j - 1] : 0;
                    matrix[i][j] = 1 + Math.min(Math.min(left, top), diag);
                    squares += matrix[i][j];
                }
            }
        }
        return squares;
    }

}
