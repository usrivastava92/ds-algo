package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KReverseLinkedListTest {

    @Parameterized.Parameters(name = "{index}: reverseList(k={1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 2, "2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 0 -> 9"},
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 5, "5 -> 4 -> 3 -> 2 -> 1 -> 0 -> 9 -> 8 -> 7 -> 6"},
                {new Integer[]{1, 2, 3}, 1, "1 -> 2 -> 3"}
        });
    }

    private final Integer[] input;
    private final int groupSize;
    private final String expected;

    public KReverseLinkedListTest(Integer[] input, int groupSize, String expected) {
        this.input = input;
        this.groupSize = groupSize;
        this.expected = expected;
    }

    @Test
    public void reverseList_reversesNodesInFixedSizeGroups() {
        ListNode actual = new KReverseLinkedList().reverseList(LinkedListTestUtils.list(input), groupSize);
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
