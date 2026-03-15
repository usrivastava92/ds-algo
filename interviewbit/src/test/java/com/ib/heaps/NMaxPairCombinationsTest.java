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
public class NMaxPairCombinationsTest {

  @Parameterized.Parameters(name = "{index}: solve({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 4, 2, 3), Arrays.asList(2, 5, 1, 6), Arrays.asList(10, 9, 9, 8)},
          {Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(6, 5)}
        });
  }

  private final List<Integer> left;
  private final List<Integer> right;
  private final List<Integer> expected;

  public NMaxPairCombinationsTest(List<Integer> left, List<Integer> right, List<Integer> expected) {
    this.left = left;
    this.right = right;
    this.expected = expected;
  }

  @Test
  public void solve_returnsTopNPairSums() {
    NMaxPairCombinations solution = new NMaxPairCombinations();
    assertEquals(
        new ArrayList<>(expected), solution.solve(new ArrayList<>(left), new ArrayList<>(right)));
  }
}
