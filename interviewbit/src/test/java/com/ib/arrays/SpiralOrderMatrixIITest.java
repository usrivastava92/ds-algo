package com.ib.arrays;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SpiralOrderMatrixIITest {

  @Parameterized.Parameters(name = "{index}: generateMatrix({0})")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {1, new int[][] {{1}}},
          {3, new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}},
          {4, new int[][] {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}}
        });
  }

  private final int input;
  private final int[][] expected;

  public SpiralOrderMatrixIITest(int input, int[][] expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void generateMatrix_buildsClockwiseSpiral() {
    SpiralOrderMatrixII solution = new SpiralOrderMatrixII();
    assertArrayEquals(expected, solution.generateMatrix(input));
  }
}
