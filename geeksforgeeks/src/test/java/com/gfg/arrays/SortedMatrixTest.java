package com.gfg.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedMatrixTest {

    @Test
    public void getMin_returnsAndPullsCurrentMinimum() {
        int[][] matrix = {
                {10, 20, 30},
                {15, 25, 35},
                {24, 29, 37}
        };

        assertEquals(10, SortedMatrix.getMin(matrix, 3));
        assertEquals(15, SortedMatrix.getMin(matrix, 3));
        assertEquals(20, SortedMatrix.getMin(matrix, 3));
    }
}
