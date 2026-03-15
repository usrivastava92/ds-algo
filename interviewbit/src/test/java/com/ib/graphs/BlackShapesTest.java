package com.ib.graphs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BlackShapesTest {

  @Parameterized.Parameters(name = "{index}: black(...) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new String[] {"OOOXOOO", "OOXXOXO", "OXOOOXO"}, 3},
          {new String[] {"XXX", "XXX"}, 1},
          {new String[] {}, 0}
        });
  }

  private final String[] input;
  private final int expected;

  public BlackShapesTest(String[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void black_countsConnectedBlackRegions() {
    BlackShapes solution = new BlackShapes();
    assertEquals(expected, solution.black(input));
  }
}
