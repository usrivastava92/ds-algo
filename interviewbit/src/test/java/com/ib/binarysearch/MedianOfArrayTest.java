package com.ib.binarysearch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MedianOfArrayTest {

  @Parameterized.Parameters(name = "{index}: findMedianSortedArrays({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 12, 15, 26), Arrays.asList(2, 13, 17, 30, 45), 15.0},
          {Arrays.asList(1, 3), Arrays.asList(2), 2.0},
          {Arrays.asList(1, 2), Arrays.asList(3, 4), 2.5},
          {Arrays.asList(), Arrays.asList(1), 1.0}
        });
  }

  private final List<Integer> left;
  private final List<Integer> right;
  private final double expected;

  public MedianOfArrayTest(List<Integer> left, List<Integer> right, double expected) {
    this.left = left;
    this.right = right;
    this.expected = expected;
  }

  @Test
  public void findMedianSortedArrays_returnsExpectedMedian() {
    MedianOfArray solution = new MedianOfArray();
    assertEquals(expected, solution.findMedianSortedArrays(left, right), 0.0);
  }
}
