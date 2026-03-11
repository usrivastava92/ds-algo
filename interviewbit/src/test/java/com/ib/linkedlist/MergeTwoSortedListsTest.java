package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MergeTwoSortedListsTest {

    @Parameterized.Parameters(name = "{index}: merge = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 4, 6, 8}, new Integer[]{2, 4, 7, 9}, "1 -> 2 -> 4 -> 4 -> 6 -> 7 -> 8 -> 9"},
                {null, new Integer[]{1, 2}, "1 -> 2"},
                {new Integer[]{1, 3}, null, "1 -> 3"}
        });
    }

    private final Integer[] left;
    private final Integer[] right;
    private final String expected;

    public MergeTwoSortedListsTest(Integer[] left, Integer[] right, String expected) {
        this.left = left;
        this.right = right;
        this.expected = expected;
    }

    @Test
    public void mergeTwoLists_mergesInSortedOrder() {
        ListNode actual = new MergeTwoSortedLists().mergeTwoLists(LinkedListTestUtils.list(left), LinkedListTestUtils.list(right));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
