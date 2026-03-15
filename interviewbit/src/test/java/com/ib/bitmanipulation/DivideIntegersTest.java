package com.ib.bitmanipulation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DivideIntegersTest {

  @Parameterized.Parameters(name = "{index}: divide({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {10, 3, 3},
          {7, -3, -2},
          {-2147483648, -1, 2147483647},
          {0, 5, 0}
        });
  }

  private final int dividend;
  private final int divisor;
  private final int expected;

  public DivideIntegersTest(int dividend, int divisor, int expected) {
    this.dividend = dividend;
    this.divisor = divisor;
    this.expected = expected;
  }

  @Test
  public void divide_returnsIntegerQuotientWithBoundsHandling() {
    DivideIntegers solution = new DivideIntegers();
    assertEquals(expected, solution.divide(dividend, divisor));
  }
}
