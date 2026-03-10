package com.ib.bitmanipulation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberOf1BitsTest {

    @Parameterized.Parameters(name = "{index}: numSetBits({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {11L, 3},
                {0L, 0},
                {255L, 8}
        });
    }

    private final Long input;
    private final int expected;

    public NumberOf1BitsTest(Long input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void numSetBits_countsSetBits() {
        NumberOf1Bits solution = new NumberOf1Bits();
        assertEquals(expected, solution.numSetBits(input));
    }
}
