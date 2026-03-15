package com.ib.bitmanipulation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ReverseBitsTest {

  @Parameterized.Parameters(name = "{index}: reverse({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {3L, 3221225472L},
          {0L, 0L},
          {1L, 2147483648L}
        });
  }

  private final long input;
  private final long expected;

  public ReverseBitsTest(long input, long expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void reverse_reversesLower32Bits() {
    ReverseBits solution = new ReverseBits();
    assertEquals(expected, solution.reverse(input));
  }
}
