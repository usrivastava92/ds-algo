package com.ib.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MinimumCharactersRequiredToMakeStringPalindromicTest {

  @Parameterized.Parameters(name = "{index}: solve({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"ABC", 2},
          {"AACECAAAA", 2},
          {"ABA", 0}
        });
  }

  private final String input;
  private final int expected;

  public MinimumCharactersRequiredToMakeStringPalindromicTest(String input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void solve_returnsMinimumCharactersToPrepend() {
    MinimumCharactersRequiredToMakeStringPalindromic solution =
        new MinimumCharactersRequiredToMakeStringPalindromic();
    assertEquals(expected, solution.solve(input));
  }
}
