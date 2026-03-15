package com.gfg.arrays;

public class SortedMatrix {
    static int getMin(int[][] matrix, int size) {
        int min = matrix[0][0];
        pullMin(matrix, 0, 0, size);
        return min;
    }

  private static void pullMin(int[][] matrix, int i, int j, int size) {
    int right = j + 1 < size ? matrix[i][j + 1] : Integer.MAX_VALUE;
    int down = i + 1 < size ? matrix[i + 1][j] : Integer.MAX_VALUE;
    if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) {
      return;
    }
    if (right < down) {
      matrix[i][j] = right;
      pullMin(matrix, i, j + 1, size);
    } else {
      matrix[i][j] = down;
      pullMin(matrix, i + 1, j, size);
    }
  }
}
