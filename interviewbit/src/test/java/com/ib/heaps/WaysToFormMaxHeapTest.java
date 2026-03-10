package com.ib.heaps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WaysToFormMaxHeapTest {

    @Parameterized.Parameters(name = "{index}: solve({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 8}
        });
    }

    private final int input;
    private final int expected;

    public WaysToFormMaxHeapTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solve_returnsNumberOfDistinctMaxHeaps() {
        WaysToFormMaxHeap solution = new WaysToFormMaxHeap();
        assertEquals(expected, solution.solve(input));
    }
}
