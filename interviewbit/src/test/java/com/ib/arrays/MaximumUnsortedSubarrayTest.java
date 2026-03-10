package com.ib.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class MaximumUnsortedSubarrayTest {

    @Parameterized.Parameters(name = "{index}: subUnsort({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 2, 4, 5}, new int[]{1, 2}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{-1}},
                {new int[]{1, 2, 6, 4, 5, 7}, new int[]{2, 4}}
        });
    }

    private final int[] input;
    private final int[] expected;

    public MaximumUnsortedSubarrayTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void subUnsort_returnsMinimalWindowToSort() {
        MaximumUnsortedSubarray solution = new MaximumUnsortedSubarray();
        assertArrayEquals(expected, solution.subUnsort(input));
    }
}
