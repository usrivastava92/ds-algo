package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveDuplicatesfromSortedListTest {

    @Parameterized.Parameters(name = "{index}: deleteDuplicates = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 1, 2, 2, 3}, "1 -> 2 -> 3"},
                {new Integer[]{1, 1, 1}, "1"},
                {new Integer[]{1}, "1"}
        });
    }

    private final Integer[] input;
    private final String expected;

    public RemoveDuplicatesfromSortedListTest(Integer[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void deleteDuplicates_removesRepeatedSortedValues() {
        ListNode actual = new RemoveDuplicatesfromSortedList().deleteDuplicates(LinkedListTestUtils.list(input));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
