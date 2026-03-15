package com.ib.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaximumSumTripletTest {

  @Parameterized.Parameters(name = "{index}: solve({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {2, 5, 3, 1, 4, 9}, 16},
          {new int[] {1, 2, 3}, 6},
          {
            new int[] {
              18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282,
              16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605
            },
            88252
          }
        });
  }

  private final int[] input;
  private final int expected;

  public MaximumSumTripletTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void solve_returnsBestIncreasingTripletSum() {
    MaximumSumTriplet solution = new MaximumSumTriplet();
    assertEquals(expected, solution.solve(input));
  }
}
