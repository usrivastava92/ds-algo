package com.ib.graphs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class WordSearchBoardTest {

  @Parameterized.Parameters(name = "{index}: exist(..., {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new String[] {"ABCE", "SFCS", "ADEE"}, "ABCCED", 1},
          {new String[] {"ABCE", "SFCS", "ADEE"}, "SEE", 1},
          {new String[] {"ABCE", "SFCS", "ADEE"}, "ABCD", 0}
        });
  }

  private final String[] board;
  private final String word;
  private final int expected;

  public WordSearchBoardTest(String[] board, String word, int expected) {
    this.board = board;
    this.word = word;
    this.expected = expected;
  }

  @Test
  public void exist_returnsWhetherWordCanBeTraced() {
    WordSearchBoard solution = new WordSearchBoard();
    assertEquals(expected, solution.exist(board, word));
  }
}
