package com.ib.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidPathTest {

    @Parameterized.Parameters(name = "{index}: solve(...) = {6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 1, 1, new int[]{2}, new int[]{3}, "NO"},
                {1, 1, 0, 0, new int[]{}, new int[]{}, "YES"},
                {1, 1, 1, 1, new int[]{0}, new int[]{0}, "NO"}
        });
    }

    private final int x;
    private final int y;
    private final int circles;
    private final int radius;
    private final int[] centersX;
    private final int[] centersY;
    private final String expected;

    public ValidPathTest(int x, int y, int circles, int radius, int[] centersX, int[] centersY, String expected) {
        this.x = x;
        this.y = y;
        this.circles = circles;
        this.radius = radius;
        this.centersX = centersX;
        this.centersY = centersY;
        this.expected = expected;
    }

    @Test
    public void solve_returnsWhetherPathExists() {
        ValidPath solution = new ValidPath();
        assertEquals(expected, solution.solve(x, y, circles, radius, centersX, centersY));
    }
}
