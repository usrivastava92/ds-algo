package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KthNodeFromMiddleTest {

    @Parameterized.Parameters(name = "{index}: solve({1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{3, 4, 7, 5, 6, 16, 15, 61, 16}, 0, 6},
                {new Integer[]{3, 4, 7, 5, 6, 16, 15, 61, 16}, 1, 5},
                {new Integer[]{3, 4, 7, 5, 6, 16, 15, 61, 16}, 3, 4},
                {new Integer[]{1, 14, 6, 16, 4, 10}, 2, 14},
                {new Integer[]{1, 14, 6, 16, 4, 10}, 10, -1}
        });
    }

    private final Integer[] input;
    private final int offset;
    private final int expected;

    public KthNodeFromMiddleTest(Integer[] input, int offset, int expected) {
        this.input = input;
        this.offset = offset;
        this.expected = expected;
    }

    @Test
    public void solve_returnsExpectedNodeValue() {
        assertEquals(expected, new KthNodeFromMiddle().solve(LinkedListTestUtils.list(input), offset));
    }
}
