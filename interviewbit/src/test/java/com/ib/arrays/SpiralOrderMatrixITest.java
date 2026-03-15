package com.ib.arrays;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SpiralOrderMatrixITest {

  @Parameterized.Parameters(name = "{index}: spiralOrder(...)")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[] {1, 2, 3, 6, 9, 8, 7, 4, 5}},
          {
            new int[][] {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {7, 8, 9, 1, 0}, {4, 5, 6, 7, 8}},
            new int[] {1, 2, 3, 4, 5, 8, 0, 8, 7, 6, 5, 4, 7, 4, 5, 6, 7, 1, 9, 8}
          }
        });
  }

  private final int[][] input;
  private final int[] expected;

  public SpiralOrderMatrixITest(int[][] input, int[] expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void spiralOrder_returnsClockwiseTraversal() {
    SpiralOrderMatrixI solution = new SpiralOrderMatrixI();
    assertArrayEquals(expected, solution.spiralOrder(input));
  }
}
