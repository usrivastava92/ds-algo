package com.gfg.arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ConvertArrayZigZagFashionTest {

  @Parameterized.Parameters(name = "{index}: zigzag({0})")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {4, 3, 7, 8, 6, 2, 1}, new int[] {3, 7, 4, 8, 2, 6, 1}},
          {new int[] {1, 4, 3, 2}, new int[] {1, 4, 2, 3}}
        });
  }

  private final int[] input;
  private final int[] expected;

  public ConvertArrayZigZagFashionTest(int[] input, int[] expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void makeZigZagModifiedBubbleSort_reordersIntoZigZagPattern() {
    int[] actual = Arrays.copyOf(input, input.length);
    ConvertArrayZigZagFashion.makeZigZagModifiedBubbleSort(actual, actual.length);
    assertArrayEquals(expected, actual);
    assertTrue(ConvertArrayZigZagFashion.validateAns(actual));
  }
}
