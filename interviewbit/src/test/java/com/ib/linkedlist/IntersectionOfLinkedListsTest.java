package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class IntersectionOfLinkedListsTest {

    @Parameterized.Parameters(name = "{index}: common={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3}, new Integer[]{5}, new Integer[]{4, 5, 6}, 4},
                {new Integer[]{1, 2}, new Integer[]{3, 4}, null, null}
        });
    }

    private final Integer[] leftPrefix;
    private final Integer[] rightPrefix;
    private final Integer[] commonValues;
    private final Integer expectedValue;

    public IntersectionOfLinkedListsTest(Integer[] leftPrefix, Integer[] rightPrefix, Integer[] commonValues, Integer expectedValue) {
        this.leftPrefix = leftPrefix;
        this.rightPrefix = rightPrefix;
        this.commonValues = commonValues;
        this.expectedValue = expectedValue;
    }

    @Test
    public void getIntersectionNode_returnsSharedNodeReference() {
        ListNode left = LinkedListTestUtils.list(leftPrefix);
        ListNode right = LinkedListTestUtils.list(rightPrefix);
        ListNode common = LinkedListTestUtils.list(commonValues);
        if (left != null && common != null) {
            LinkedListUtils.getLast(left).next = common;
        }
        if (right != null && common != null) {
            LinkedListUtils.getLast(right).next = common;
        }

        ListNode actual = new IntersectionOfLinkedLists().getIntersectionNode(left, right);
        if (expectedValue == null) {
            assertNull(actual);
            return;
        }
        assertSame(common, actual);
        assertEquals(expectedValue.intValue(), actual.val);
    }
}
