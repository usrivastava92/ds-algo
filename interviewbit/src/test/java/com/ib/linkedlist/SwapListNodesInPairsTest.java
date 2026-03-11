package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SwapListNodesInPairsTest {

    @Parameterized.Parameters(name = "{index}: swapPairs = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3, 4}, "2 -> 1 -> 4 -> 3"},
                {new Integer[]{1, 2, 3}, "2 -> 1 -> 3"},
                {new Integer[]{1}, "1"}
        });
    }

    private final Integer[] input;
    private final String expected;

    public SwapListNodesInPairsTest(Integer[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void swapPairs_swapsAdjacentNodes() {
        ListNode actual = new SwapListNodesInPairs().swapPairs(LinkedListTestUtils.list(input));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
