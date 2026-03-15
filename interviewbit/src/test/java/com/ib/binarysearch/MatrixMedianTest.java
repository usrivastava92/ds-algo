package com.ib.binarysearch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MatrixMedianTest {

  @Parameterized.Parameters(name = "{index}: findMedian(...) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[][] {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}}, 5},
          {new int[][] {{5, 17, 100}}, 17},
          {new int[][] {{1, 2}, {3, 4}}, 2},
          {new int[][] {}, 0},
          {null, 0}
        });
  }

  private final int[][] input;
  private final int expected;

  public MatrixMedianTest(int[][] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void findMedian_returnsExpectedMedian() {
    MatrixMedian solution = new MatrixMedian();
    assertEquals(expected, solution.findMedian(input));
  }
}
