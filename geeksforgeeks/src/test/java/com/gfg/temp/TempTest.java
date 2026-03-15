package com.gfg.temp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TempTest {

    @Parameterized.Parameters(name = "{index}: equalStacks(...) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 2, 1, 1, 1}, new int[]{4, 3, 2}, new int[]{1, 1, 4, 1}, 5},
                {new int[]{1, 1, 1, 1}, new int[]{2, 3}, new int[]{1, 4}, 0},
                {new int[]{100}, new int[]{50}, new int[]{1}, 0}
        });
    }

    private final int[] left;
    private final int[] middle;
    private final int[] right;
    private final int expected;

    public TempTest(int[] left, int[] middle, int[] right, int expected) {
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.expected = expected;
    }

    @Test
    public void equalStacks_returnsMaxPossibleEqualHeight() {
        assertEquals(expected, Temp.equalStacks(left, middle, right));
    }
}
