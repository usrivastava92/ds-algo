package com.ib.hashing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WindowStringTest {

    @Parameterized.Parameters(name = "{index}: minWindow({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ADOBECODEBANC", "ABC", "BANC"},
                {"a", "a", "a"},
                {"a", "aa", ""}
        });
    }

    private final String source;
    private final String target;
    private final String expected;

    public WindowStringTest(String source, String target, String expected) {
        this.source = source;
        this.target = target;
        this.expected = expected;
    }

    @Test
    public void minWindow_returnsShortestSubstringContainingTarget() {
        WindowString solution = new WindowString();
        assertEquals(expected, solution.minWindow(source, target));
    }
}
