package com.ib.bitmanipulation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DifferentBitsSumPairwiseTest {

  @Parameterized.Parameters(name = "{index}: cntBits({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 3, 5), 8},
          {Arrays.asList(0, 0), 0},
          {Arrays.asList(1, 2), 4}
        });
  }

  private final List<Integer> input;
  private final int expected;

  public DifferentBitsSumPairwiseTest(List<Integer> input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void cntBits_returnsPairwiseBitDifferenceSum() {
    DifferentBitsSumPairwise solution = new DifferentBitsSumPairwise();
    assertEquals(expected, solution.cntBits(new ArrayList<>(input)));
  }
}
