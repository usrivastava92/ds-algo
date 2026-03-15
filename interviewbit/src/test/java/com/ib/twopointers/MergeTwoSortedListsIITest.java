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
public class MergeTwoSortedListsIITest {

  @Parameterized.Parameters(name = "{index}: merge({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(3), Arrays.asList(-4, -3), Arrays.asList(-4, -3, 3)},
          {Arrays.asList(1, 5, 8), Arrays.asList(6, 9), Arrays.asList(1, 5, 6, 8, 9)},
          {Arrays.asList(), Arrays.asList(1, 2), Arrays.asList(1, 2)}
        });
  }

  private final List<Integer> left;
  private final List<Integer> right;
  private final List<Integer> expected;

  public MergeTwoSortedListsIITest(
      List<Integer> left, List<Integer> right, List<Integer> expected) {
    this.left = left;
    this.right = right;
    this.expected = expected;
  }

  @Test
  public void merge_updatesFirstListInSortedOrder() {
    MergeTwoSortedListsII solution = new MergeTwoSortedListsII();
    ArrayList<Integer> merged = new ArrayList<>(left);
    solution.merge(merged, new ArrayList<>(right));
    assertEquals(new ArrayList<>(expected), merged);
  }
}
