package com.leet.daysofcode.year2020.december.week5;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.stream.IntStream;

class GameOfLife {

    public static void main(String[] args) {
        int[][][] inputs = {{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}};
        int[][][] outputs = {{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}};
        GameOfLife gameOfLife = new GameOfLife();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(inputs[i]);
            gameOfLife.gameOfLife(inputs[i]);
            System.out.println("Output : ");
            ArrayUtils.printArr(inputs[i]);
            Assert.assertArrayEquals(outputs[i], inputs[i]);
        });
    }


    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ones = 0;
                if (i - 1 > -1 && j - 1 > -1) {
                    ones += decodeOld(board, i - 1, j - 1);
                }
                if (i - 1 > -1) {
                    ones += decodeOld(board, i - 1, j);
                }
                if (i - 1 > -1 && j + 1 < m) {
                    ones += decodeOld(board, i - 1, j + 1);
                }
                if (j - 1 > -1) {
                    ones += decodeOld(board, i, j - 1);
                }
                if (j + 1 < m) {
                    ones += board[i][j + 1];
                }
                if (i + 1 < n && j - 1 > -1) {
                    ones += board[i + 1][j - 1];
                }
                if (i + 1 < n) {
                    ones += board[i + 1][j];
                }
                if (i + 1 < n && j + 1 < m) {
                    ones += board[i + 1][j + 1];
                }

                if (ones < 2 || ones > 3) {
                    encode(board, i, j, 0);
                } else if (ones == 3 && board[i][j] == 0) {
                    encode(board, i, j, 1);
                } else {
                    encode(board, i, j, board[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = decodeNew(board, i, j);
            }
        }
    }

    private void encode(int[][] board, int i, int j, int val) {
        board[i][j] = (board[i][j] * 2) + val;
    }

    private int decodeOld(int[][] board, int i, int j) {
        return board[i][j] / 2;
    }

    private int decodeNew(int[][] board, int i, int j) {
        return board[i][j] % 2;
    }

}