package com.ib.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KnightOnChessBoardTest {

    @Parameterized.Parameters(name = "{index}: knight(...) = {6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {8, 8, 1, 1, 8, 8, 6},
                {2, 2, 1, 1, 2, 2, -1},
                {4, 7, 2, 6, 2, 4, 2}
        });
    }

    private final int rows;
    private final int cols;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int expected;

    public KnightOnChessBoardTest(int rows, int cols, int startX, int startY, int endX, int endY, int expected) {
        this.rows = rows;
        this.cols = cols;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.expected = expected;
    }

    @Test
    public void knight_returnsMinimumMoves() {
        KnightOnChessBoard solution = new KnightOnChessBoard();
        assertEquals(expected, solution.knight(rows, cols, startX, startY, endX, endY));
    }
}
