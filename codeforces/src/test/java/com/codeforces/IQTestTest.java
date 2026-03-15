package com.codeforces;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IQTestTest {

  @Parameterized.Parameters(name = "{index}: findDifferentParityIndex(...) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {2, 4, 7, 8, 10}, 3},
          {new int[] {1, 2, 1, 1}, 2},
          {new int[] {2, 4, 6}, -1}
        });
  }

  private final int[] input;
  private final int expected;

  public IQTestTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void findDifferentParityIndex_returnsOneBasedOutlierPosition() {
    IQTest solution = new IQTest();
    assertEquals(expected, solution.findDifferentParityIndex(input));
  }
}
