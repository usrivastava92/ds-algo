package com.ib.twopointers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxContinuousSeriesof1sTest {

  @Parameterized.Parameters(name = "{index}: maxone({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1), 1, Arrays.asList(0, 1, 2, 3, 4)},
          {Arrays.asList(1, 0, 1, 1, 0), 1, Arrays.asList(0, 1, 2, 3)},
          {Arrays.asList(1, 1, 1), 0, Arrays.asList(0, 1, 2)}
        });
  }

  private final List<Integer> input;
  private final int maxZeroFlips;
  private final List<Integer> expected;

  public MaxContinuousSeriesof1sTest(
      List<Integer> input, int maxZeroFlips, List<Integer> expected) {
    this.input = input;
    this.maxZeroFlips = maxZeroFlips;
    this.expected = expected;
  }

  @Test
  public void maxone_returnsIndicesForBestWindow() {
    MaxContinuousSeriesof1s solution = new MaxContinuousSeriesof1s();
    assertEquals(new ArrayList<>(expected), solution.maxone(new ArrayList<>(input), maxZeroFlips));
  }
}
