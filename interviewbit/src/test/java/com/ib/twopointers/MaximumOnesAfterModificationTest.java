package com.ib.twopointers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaximumOnesAfterModificationTest {

  @Parameterized.Parameters(name = "{index}: solve({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {1, 0, 0, 1, 1, 0, 1}, 1, 4},
          {new int[] {1, 0, 0, 1, 0, 1, 0, 1, 0, 1}, 2, 5},
          {new int[] {1, 0}, 1, 2},
          {new int[] {}, 3, 0},
          {null, 1, 0}
        });
  }

  private final int[] input;
  private final int maxZeroFlips;
  private final int expected;

  public MaximumOnesAfterModificationTest(int[] input, int maxZeroFlips, int expected) {
    this.input = input;
    this.maxZeroFlips = maxZeroFlips;
    this.expected = expected;
  }

  @Test
  public void solve_returnsExpectedWindowLength() {
    MaximumOnesAfterModification solution = new MaximumOnesAfterModification();
    assertEquals(expected, solution.solve(input, maxZeroFlips));
  }
}
