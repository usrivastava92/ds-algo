package com.ib.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class NextPermutationTest {

    @Parameterized.Parameters(name = "{index}: nextPermutation({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3}, new int[]{1, 3, 2}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{1, 1, 5}, new int[]{1, 5, 1}},
                {new int[]{20, 50, 113}, new int[]{20, 113, 50}}
        });
    }

    private final int[] input;
    private final int[] expected;

    public NextPermutationTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void nextPermutation_returnsNextLexicographicPermutation() {
        NextPermutation solution = new NextPermutation();
        assertArrayEquals(expected, solution.nextPermutation(input));
    }
}
