package com.ib.heaps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DistinctNumbersInWindowTest {

  @Parameterized.Parameters(name = "{index}: dNums({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 2, 1, 3, 4, 3), 3, Arrays.asList(2, 3, 3, 2)},
          {Arrays.asList(1, 1, 1, 1), 2, Arrays.asList(1, 1, 1)},
          {Arrays.asList(1, 2), 3, Arrays.asList()}
        });
  }

  private final List<Integer> input;
  private final int window;
  private final List<Integer> expected;

  public DistinctNumbersInWindowTest(List<Integer> input, int window, List<Integer> expected) {
    this.input = input;
    this.window = window;
    this.expected = expected;
  }

  @Test
  public void dNums_returnsDistinctCountsPerWindow() {
    DistinctNumbersInWindow solution = new DistinctNumbersInWindow();
    assertEquals(new ArrayList<>(expected), solution.dNums(new ArrayList<>(input), window));
  }
}
