package com.ib.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CommutableIslandsTest {

    @Parameterized.Parameters(name = "{index}: solve({0}, ...) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[][]{{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}}, 6},
                {4, new int[][]{{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}}, 6},
                {3, new int[][]{{1, 2, 10}, {2, 3, 5}, {1, 3, 9}}, 14}
        });
    }

    private final int islands;
    private final int[][] edges;
    private final int expected;

    public CommutableIslandsTest(int islands, int[][] edges, int expected) {
        this.islands = islands;
        this.edges = edges;
        this.expected = expected;
    }

    @Test
    public void solve_returnsMinimumSpanningTreeWeight() {
        CommutableIslands solution = new CommutableIslands();
        assertEquals(expected, solution.solve(islands, edges));
    }
}
