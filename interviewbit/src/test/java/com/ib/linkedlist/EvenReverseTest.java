package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EvenReverseTest {

    @Parameterized.Parameters(name = "{index}: solve({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3, 4}, "1 -> 4 -> 3 -> 2"},
                {new Integer[]{1, 2, 3}, "1 -> 2 -> 3"},
                {new Integer[]{1}, "1"}
        });
    }

    private final Integer[] input;
    private final String expected;

    public EvenReverseTest(Integer[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solve_reversesEvenPositionNodes() {
        ListNode actual = new EvenReverse().solve(LinkedListTestUtils.list(input));
        assertEquals(expected, LinkedListTestUtils.asString(actual));
    }
}
