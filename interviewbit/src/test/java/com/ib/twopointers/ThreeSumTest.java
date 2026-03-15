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
public class ThreeSumTest {

  @Parameterized.Parameters(name = "{index}: threeSumClosest({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(2, 1, -4, -1), 1, 2},
          {Arrays.asList(-1, 2, 1, -4), 1, 2},
          {Arrays.asList(0, 0, 0), 1, 0}
        });
  }

  private final List<Integer> input;
  private final int target;
  private final int expected;

  public ThreeSumTest(List<Integer> input, int target, int expected) {
    this.input = input;
    this.target = target;
    this.expected = expected;
  }

  @Test
  public void threeSumClosest_returnsNearestTripletSum() {
    ThreeSum solution = new ThreeSum();
    assertEquals(expected, solution.threeSumClosest(new ArrayList<>(input), target));
  }
}
