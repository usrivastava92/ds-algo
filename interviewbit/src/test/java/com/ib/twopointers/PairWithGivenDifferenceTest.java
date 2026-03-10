package com.ib.twopointers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PairWithGivenDifferenceTest {

    @Parameterized.Parameters(name = "{index}: solve({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 10, 3, 2, 50, 80}, 78, 1},
                {new int[]{-10, 20}, 30, 1},
                {new int[]{5, 10, 3, 2, 50, 80}, 80, 0},
                {new int[]{5, 10, 3, 2, 50, 80}, 47, 1},
                {new int[]{5, 10, 3, 2, 50, 80}, 1, 1},
                {new int[]{1}, 0, 0},
                {null, 2, 0}
        });
    }

    private final int[] input;
    private final int difference;
    private final int expected;

    public PairWithGivenDifferenceTest(int[] input, int difference, int expected) {
        this.input = input;
        this.difference = difference;
        this.expected = expected;
    }

    @Test
    public void solve_returnsWhetherPairExists() {
        PairWithGivenDifference solution = new PairWithGivenDifference();
        assertEquals(expected, solution.solve(input == null ? null : Arrays.copyOf(input, input.length), difference));
    }
}
