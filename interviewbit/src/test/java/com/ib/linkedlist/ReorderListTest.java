package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReorderListTest {

    @Parameterized.Parameters(name = "{index}: reorder = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, "1 -> 8 -> 2 -> 7 -> 3 -> 6 -> 4 -> 5"},
                {new Integer[]{1, 2, 3, 4, 5, 6, 7}, "1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4"},
                {new Integer[]{1}, "1"}
        });
    }

    private final Integer[] input;
    private final String expected;

    public ReorderListTest(Integer[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void reorderList_alternatesHeadAndTailNodes() {
        ListNode actual = new ReorderList().reorderList(LinkedListTestUtils.list(input));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
