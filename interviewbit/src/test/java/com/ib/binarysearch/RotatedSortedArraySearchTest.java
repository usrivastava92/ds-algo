package com.ib.binarysearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RotatedSortedArraySearchTest {

    @Parameterized.Parameters(name = "{index}: search({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 4, 0},
                {new int[]{5, 17, 100, 3}, 6, -1},
                {new int[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100}, 202, 8},
                {new int[]{1}, 1, 0},
                {null, 1, -1}
        });
    }

    private final int[] input;
    private final int target;
    private final int expected;

    public RotatedSortedArraySearchTest(int[] input, int target, int expected) {
        this.input = input;
        this.target = target;
        this.expected = expected;
    }

    @Test
    public void search_returnsMatchingIndexWhenPresent() {
        RotatedSortedArraySearch solution = new RotatedSortedArraySearch();
        assertEquals(expected, solution.search(input, target));
    }
}
