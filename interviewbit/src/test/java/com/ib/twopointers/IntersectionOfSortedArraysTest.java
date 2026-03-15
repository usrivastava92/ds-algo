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
public class IntersectionOfSortedArraysTest {

  @Parameterized.Parameters(name = "{index}: intersect({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(10000), Arrays.asList(10000), Arrays.asList(10000)},
          {Arrays.asList(1, 2, 2, 3), Arrays.asList(2, 2, 4), Arrays.asList(2, 2)},
          {Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6), Arrays.asList()}
        });
  }

  private final List<Integer> left;
  private final List<Integer> right;
  private final List<Integer> expected;

  public IntersectionOfSortedArraysTest(
      List<Integer> left, List<Integer> right, List<Integer> expected) {
    this.left = left;
    this.right = right;
    this.expected = expected;
  }

  @Test
  public void intersect_returnsCommonItemsWithMultiplicity() {
    IntersectionOfSortedArrays solution = new IntersectionOfSortedArrays();
    assertEquals(new ArrayList<>(expected), solution.intersect(left, right));
  }
}
