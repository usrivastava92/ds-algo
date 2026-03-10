package com.ib.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumConsecutiveGapTest {

    @Parameterized.Parameters(name = "{index}: maximumGap({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 10, 5), 5},
                {Arrays.asList(1, 1, 1), 0},
                {Arrays.asList(3, 6, 9, 1), 3}
        });
    }

    private final List<Integer> input;
    private final int expected;

    public MaximumConsecutiveGapTest(List<Integer> input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void maximumGap_returnsLargestSortedAdjacentDifference() {
        MaximumConsecutiveGap solution = new MaximumConsecutiveGap();
        assertEquals(expected, solution.maximumGap(input));
    }
}
