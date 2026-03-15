package com.ib.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IntToRomanTest {

  @Parameterized.Parameters(name = "{index}: intToRoman({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {23, "XXIII"},
          {4, "IV"},
          {9, "IX"},
          {58, "LVIII"},
          {1994, "MCMXCIV"}
        });
  }

  private final int input;
  private final String expected;

  public IntToRomanTest(int input, String expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void intToRoman_returnsExpectedRomanNumeral() {
    IntToRoman solution = new IntToRoman();
    assertEquals(expected, solution.intToRoman(input));
  }
}
