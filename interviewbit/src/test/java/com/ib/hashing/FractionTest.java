package com.ib.hashing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FractionTest {

    @Parameterized.Parameters(name = "{index}: fractionToDecimal({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, "0.5"},
                {2, 3, "0.(6)"},
                {-50, 8, "-6.25"},
                {1, 5, "0.2"}
        });
    }

    private final int numerator;
    private final int denominator;
    private final String expected;

    public FractionTest(int numerator, int denominator, String expected) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.expected = expected;
    }

    @Test
    public void fractionToDecimal_formatsRepeatingDecimals() {
        Fraction solution = new Fraction();
        assertEquals(expected, solution.fractionToDecimal(numerator, denominator));
    }
}
