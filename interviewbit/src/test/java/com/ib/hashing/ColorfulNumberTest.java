package com.ib.hashing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ColorfulNumberTest {

    @Parameterized.Parameters(name = "{index}: colorful({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3245, 1},
                {326, 0},
                {23, 1}
        });
    }

    private final int input;
    private final int expected;

    public ColorfulNumberTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void colorful_returnsWhetherProductsAreUnique() {
        ColorfulNumber solution = new ColorfulNumber();
        assertEquals(expected, solution.colorful(input));
    }
}
