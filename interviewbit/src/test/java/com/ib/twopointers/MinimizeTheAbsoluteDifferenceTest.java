package com.ib.twopointers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimizeTheAbsoluteDifferenceTest {

    @Parameterized.Parameters(name = "{index}: solve({0}, {1}, {2}) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 4, 5, 8, 10), Arrays.asList(6, 9, 10), Arrays.asList(2, 3, 6, 10), 0},
                {Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), Arrays.asList(1, 2, 3), 0},
                {Arrays.asList(5), Arrays.asList(8), Arrays.asList(10), 5}
        });
    }

    private final List<Integer> a;
    private final List<Integer> b;
    private final List<Integer> c;
    private final int expected;

    public MinimizeTheAbsoluteDifferenceTest(List<Integer> a, List<Integer> b, List<Integer> c, int expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Test
    public void solve_returnsMinimumPossibleSpread() {
        MinimizeTheAbsoluteDifference solution = new MinimizeTheAbsoluteDifference();
        assertEquals(expected, solution.solve(new ArrayList<>(a), new ArrayList<>(b), new ArrayList<>(c)));
    }
}
