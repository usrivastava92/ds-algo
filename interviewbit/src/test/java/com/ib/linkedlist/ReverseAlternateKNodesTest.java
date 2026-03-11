package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReverseAlternateKNodesTest {

    @Parameterized.Parameters(name = "{index}: solve(k={1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{3, 4, 7, 5, 6, 6, 15, 61, 16}, 3, "7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15"},
                {new Integer[]{1, 4, 6, 6, 4, 10}, 2, "4 -> 1 -> 6 -> 6 -> 10 -> 4"},
                {new Integer[]{1, 2, 3}, 1, "1 -> 2 -> 3"}
        });
    }

    private final Integer[] input;
    private final int groupSize;
    private final String expected;

    public ReverseAlternateKNodesTest(Integer[] input, int groupSize, String expected) {
        this.input = input;
        this.groupSize = groupSize;
        this.expected = expected;
    }

    @Test
    public void solve_reversesAlternateGroups() {
        ListNode actual = new ReverseAlternateKNodes().solve(LinkedListTestUtils.list(input), groupSize);
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
