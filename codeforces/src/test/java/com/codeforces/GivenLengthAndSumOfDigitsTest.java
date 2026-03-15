package com.codeforces;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GivenLengthAndSumOfDigitsTest {

  @Parameterized.Parameters(name = "{index}: findMinAndMax({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {2, 15, "69 96"},
          {3, 20, "299 992"},
          {1, 0, "0 0"},
          {2, 0, "-1 -1"}
        });
  }

  private final int length;
  private final int sum;
  private final String expected;

  public GivenLengthAndSumOfDigitsTest(int length, int sum, String expected) {
    this.length = length;
    this.sum = sum;
    this.expected = expected;
  }

  @Test
  public void findMinAndMax_returnsSmallestAndLargestNumbers() {
    GivenLengthAndSumOfDigits solution = new GivenLengthAndSumOfDigits();
    assertEquals(expected, solution.findMinAndMax(length, sum));
  }
}
