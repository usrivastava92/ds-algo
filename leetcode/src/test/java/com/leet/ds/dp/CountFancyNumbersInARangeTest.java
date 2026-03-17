package com.leet.ds.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountFancyNumbersInARangeTest {

  public CountFancyNumbersInARangeTest() {}

  private final CountFancyNumbersInARange.Solution solution =
      new CountFancyNumbersInARange.Solution();

  @Test
  public void shouldMatchSampleCaseOne() {
    assertEquals(3L, solution.countFancy(8, 10));
  }

  @Test
  public void shouldMatchSampleCaseTwo() {
    assertEquals(1L, solution.countFancy(12340, 12341));
  }

  @Test
  public void shouldMatchSampleCaseThree() {
    assertEquals(0L, solution.countFancy(123456788, 123456788));
  }
}
