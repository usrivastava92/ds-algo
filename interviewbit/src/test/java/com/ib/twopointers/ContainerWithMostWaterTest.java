package com.ib.twopointers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ContainerWithMostWaterTest {

  @Parameterized.Parameters(name = "{index}: maxArea({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {1, 5, 4, 3}, 6},
          {new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
          {new int[] {1, 1}, 1},
          {new int[] {}, 0},
          {null, 0}
        });
  }

  private final int[] input;
  private final int expected;

  public ContainerWithMostWaterTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void maxArea_returnsExpectedArea() {
    ContainerWithMostWater solution = new ContainerWithMostWater();
    assertEquals(expected, solution.maxArea(input));
  }
}
