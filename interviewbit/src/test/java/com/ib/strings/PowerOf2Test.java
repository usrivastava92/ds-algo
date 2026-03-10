package com.ib.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PowerOf2Test {

    @Parameterized.Parameters(name = "{index}: power({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"128", 1},
                {"100", 0},
                {"1", 0},
                {"1024", 1},
                {null, 0}
        });
    }

    private final String input;
    private final int expected;

    public PowerOf2Test(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void power_returnsWhetherDecimalStringIsPowerOfTwo() {
        PowerOf2 solution = new PowerOf2();
        assertEquals(expected, solution.power(input));
    }
}
