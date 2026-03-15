package com.ib.graphs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SmallestMultipleWith0And1Test {

  @Parameterized.Parameters(name = "{index}: multiple({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {55, "110"},
          {2, "10"},
          {1, "1"}
        });
  }

  private final int input;
  private final String expected;

  public SmallestMultipleWith0And1Test(int input, String expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void multiple_returnsSmallestBinaryDigitMultiple() {
    SmallestMultipleWith0And1 solution = new SmallestMultipleWith0And1();
    assertEquals(expected, solution.multiple(input));
  }
}
