package com.leet.ds.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DetermineWhetherMatrixCanBeObtainedByRotation {

  public static void main(String[] args) {
    DetermineWhetherMatrixCanBeObtainedByRotation solver =
        new DetermineWhetherMatrixCanBeObtainedByRotation();

    int[][] mat1 = {{0, 1}, {1, 0}};
    int[][] target1 = {{1, 0}, {0, 1}};
    System.out.println(solver.findRotation(mat1, target1));

    int[][] mat2 = {{0, 1}, {1, 1}};
    int[][] target2 = {{1, 0}, {0, 1}};
    System.out.println(solver.findRotation(mat2, target2));
  }

  public boolean findRotation(int[][] mat, int[][] target) {
    int n = mat.length;
    for (int rotation = 0; rotation < 4; rotation++) {
      if (matchesForRotation(mat, target, n, rotation)) {
        return true;
      }
    }
    return false;
  }

  private boolean matchesForRotation(int[][] mat, int[][] target, int n, int rotation) {
    RotatingIterator rotatedMat = new RotatingIterator(mat, n, rotation);
    RotatingIterator targetIterator = new RotatingIterator(target, n, 0);

    while (rotatedMat.hasNext() && targetIterator.hasNext()) {
      if (!rotatedMat.next().equals(targetIterator.next())) {
        return false;
      }
    }
    return !rotatedMat.hasNext() && !targetIterator.hasNext();
  }

  private static final class RotatingIterator implements Iterator<Integer> {

    private final int[][] matrix;
    private final int n;
    private final int rotation;
    private int index;

    private RotatingIterator(int[][] matrix, int n, int rotation) {
      this.matrix = matrix;
      this.n = n;
      this.rotation = rotation;
      this.index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < n * n;
    }

    @Override
    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      int row = index / n;
      int col = index % n;
      index++;

      if (rotation == 0) {
        return matrix[row][col];
      }
      if (rotation == 1) {
        return matrix[n - 1 - col][row];
      }
      if (rotation == 2) {
        return matrix[n - 1 - row][n - 1 - col];
      }
      return matrix[col][n - 1 - row];
    }
  }
}
