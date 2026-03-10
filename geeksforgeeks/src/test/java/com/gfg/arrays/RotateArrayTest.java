package com.gfg.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class RotateArrayTest {

    @Parameterized.Parameters(name = "{index}: rotate({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{3, 4, 5, 1, 2}},
                {new int[]{1, 2, 3, 4, 5}, 7, new int[]{3, 4, 5, 1, 2}},
                {new int[]{1, 2, 3}, 0, new int[]{1, 2, 3}}
        });
    }

    private final int[] input;
    private final int k;
    private final int[] expected;

    public RotateArrayTest(int[] input, int k, int[] expected) {
        this.input = input;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void rotate_rotatesArrayLeftByKPositions() {
        int[] actual = Arrays.copyOf(input, input.length);
        int normalized = actual.length == 0 ? 0 : k % actual.length;
        RotateArray.rotate(actual, normalized, actual.length);
        assertArrayEquals(expected, actual);
    }
}
