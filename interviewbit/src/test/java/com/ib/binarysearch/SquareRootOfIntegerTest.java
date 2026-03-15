package com.ib.binarysearch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SquareRootOfIntegerTest {

  @Parameterized.Parameters(name = "{index}: sqrt({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {1, 1},
          {4, 2},
          {8, 2},
          {2147483647, 46340}
        });
  }

  private final int input;
  private final int expected;

  public SquareRootOfIntegerTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void sqrt_returnsFloorOfSquareRoot() {
    SquareRootOfInteger solution = new SquareRootOfInteger();
    assertEquals(expected, solution.sqrt(input));
  }
}
