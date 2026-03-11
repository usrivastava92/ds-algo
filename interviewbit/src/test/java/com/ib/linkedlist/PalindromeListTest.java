package com.ib.linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalindromeListTest {

    @Parameterized.Parameters(name = "{index}: lPalin = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 1}, 1},
                {new Integer[]{1, 2, 1}, 1},
                {new Integer[]{1, 2, 2, 1}, 1},
                {new Integer[]{1, 2, 3, 2, 1}, 1},
                {new Integer[]{1, 5, 3, 2, 1}, 0}
        });
    }

    private final Integer[] input;
    private final int expected;

    public PalindromeListTest(Integer[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void lPalin_detectsWhetherListIsPalindrome() {
        assertEquals(expected, new PalindromeList().lPalin(LinkedListTestUtils.list(input)));
    }
}
