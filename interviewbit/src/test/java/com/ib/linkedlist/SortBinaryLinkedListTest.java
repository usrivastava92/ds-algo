package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SortBinaryLinkedListTest {

    @Parameterized.Parameters(name = "{index}: solve = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 0, 0, 1}, "0 -> 0 -> 1 -> 1"},
                {new Integer[]{0, 0, 1, 1, 0}, "0 -> 0 -> 0 -> 1 -> 1"},
                {new Integer[]{1}, "1"}
        });
    }

    private final Integer[] input;
    private final String expected;

    public SortBinaryLinkedListTest(Integer[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solve_sortsBinaryListInPlace() {
        ListNode actual = new SortBinaryLinkedList().solve(LinkedListTestUtils.list(input));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
