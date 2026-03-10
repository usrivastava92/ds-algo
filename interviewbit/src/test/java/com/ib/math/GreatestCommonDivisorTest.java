package com.ib.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GreatestCommonDivisorTest {

    @Parameterized.Parameters(name = "{index}: gcd({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {48, 18, 6},
                {7, 7, 7},
                {0, 5, 5},
                {270, 192, 6}
        });
    }

    private final int left;
    private final int right;
    private final int expected;

    public GreatestCommonDivisorTest(int left, int right, int expected) {
        this.left = left;
        this.right = right;
        this.expected = expected;
    }

    @Test
    public void gcd_returnsGreatestCommonDivisor() {
        GreatestCommonDivisor solution = new GreatestCommonDivisor();
        assertEquals(expected, solution.gcd(left, right));
    }
}
