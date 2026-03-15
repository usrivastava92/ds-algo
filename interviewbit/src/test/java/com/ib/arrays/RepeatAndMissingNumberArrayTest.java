package com.ib.arrays;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RepeatAndMissingNumberArrayTest {

  @Parameterized.Parameters(name = "{index}: repeatedNumber({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(3, 1, 2, 5, 3), Arrays.asList(3, 4)},
          {Arrays.asList(1, 1), Arrays.asList(1, 2)}
        });
  }

  private final List<Integer> input;
  private final List<Integer> expected;

  public RepeatAndMissingNumberArrayTest(List<Integer> input, List<Integer> expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void repeatedNumber_returnsRepeatedAndMissingValues() {
    RepeatAndMissingNumberArray solution = new RepeatAndMissingNumberArray();
    assertEquals(new ArrayList<>(expected), solution.repeatedNumber(input));
  }
}
