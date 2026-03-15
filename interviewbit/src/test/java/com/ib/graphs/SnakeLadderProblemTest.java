package com.ib.graphs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SnakeLadderProblemTest {

  @Parameterized.Parameters(name = "{index}: snakeLadder(...) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {
            new int[][] {{32, 62}, {42, 68}, {12, 98}},
            new int[][] {{95, 13}, {97, 25}, {93, 37}, {79, 27}, {75, 19}, {49, 47}, {67, 17}},
            3
          },
          {
            new int[][] {{8, 52}, {6, 80}, {26, 42}, {2, 72}},
            new int[][] {
              {51, 19}, {39, 11}, {37, 29}, {81, 3}, {59, 5}, {79, 23}, {53, 7}, {43, 33}, {77, 21}
            },
            5
          },
          {new int[][] {{3, 54}, {37, 100}}, new int[][] {{56, 33}}, 3}
        });
  }

  private final int[][] ladders;
  private final int[][] snakes;
  private final int expected;

  public SnakeLadderProblemTest(int[][] ladders, int[][] snakes, int expected) {
    this.ladders = ladders;
    this.snakes = snakes;
    this.expected = expected;
  }

  @Test
  public void snakeLadder_returnsMinimumDiceThrows() {
    SnakeLadderProblem solution = new SnakeLadderProblem();
    assertEquals(expected, solution.snakeLadder(ladders, snakes));
  }
}
