package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReverseLinkListIITest {

    @Parameterized.Parameters(name = "{index}: reverseBetween({1}, {2}) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3}, 1, 2, "2 -> 1 -> 3"},
                {new Integer[]{1, 2, 3, 4, 5}, 2, 4, "1 -> 4 -> 3 -> 2 -> 5"},
                {new Integer[]{1}, 1, 1, "1"}
        });
    }

    private final Integer[] input;
    private final int from;
    private final int to;
    private final String expected;

    public ReverseLinkListIITest(Integer[] input, int from, int to, String expected) {
        this.input = input;
        this.from = from;
        this.to = to;
        this.expected = expected;
    }

    @Test
    public void reverseBetween_reversesRequestedSublist() {
        ListNode actual = new ReverseLinkListII().reverseBetween(LinkedListTestUtils.list(input), from, to);
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
