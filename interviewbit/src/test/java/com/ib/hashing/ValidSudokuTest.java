package com.ib.hashing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ValidSudokuTest {

  @Parameterized.Parameters(name = "{index}: isValidSudoku(...) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {
            Arrays.asList(
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"),
            1
          },
          {
            Arrays.asList(
                "83..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"),
            0
          }
        });
  }

  private final List<String> board;
  private final int expected;

  public ValidSudokuTest(List<String> board, int expected) {
    this.board = board;
    this.expected = expected;
  }

  @Test
  public void isValidSudoku_validatesRowsColumnsAndBoxes() {
    ValidSudoku solution = new ValidSudoku();
    assertEquals(expected, solution.isValidSudoku(board));
  }
}
