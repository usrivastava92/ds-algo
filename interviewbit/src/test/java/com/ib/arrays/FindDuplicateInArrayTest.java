package com.ib.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FindDuplicateInArrayTest {

  @Parameterized.Parameters(name = "{index}: repeatedNumber({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {3, 4, 1, 4, 1}, 4},
          {new int[] {1, 1}, 1},
          {new int[] {2, 1, 3, 4, 2}, 2}
        });
  }

  private final int[] input;
  private final int expected;

  public FindDuplicateInArrayTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void repeatedNumber_returnsOneDuplicate() {
    FindDuplicateInArray solution = new FindDuplicateInArray();
    assertEquals(expected, solution.repeatedNumber(Arrays.copyOf(input, input.length)));
  }
}
