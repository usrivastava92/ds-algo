package com.ib.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConvertToPalindromeTest {

    @Parameterized.Parameters(name = "{index}: solveDp({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcba", 1},
                {"abecbea", 0},
                {"phmjjmap", 0},
                {"ivjwvi", 1},
                {null, 0}
        });
    }

    private final String input;
    private final int expected;

    public ConvertToPalindromeTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solveDp_returnsWhetherStringCanBecomePalindrome() {
        ConvertToPalindrome solution = new ConvertToPalindrome();
        assertEquals(expected, solution.solveDp(input));
    }
}
