package com.ib.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegionInBinaryMatrixTest {

    @Parameterized.Parameters(name = "{index}: solve(...) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{0, 0, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}}, 6},
                {new int[][]{{1, 1, 1}, {0, 0, 1}}, 4}
        });
    }

    private final int[][] input;
    private final int expected;

    public RegionInBinaryMatrixTest(int[][] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solve_returnsLargestConnectedRegionSize() {
        RegionInBinaryMatrix solution = new RegionInBinaryMatrix();
        assertEquals(expected, solution.solve(input));
    }
}
