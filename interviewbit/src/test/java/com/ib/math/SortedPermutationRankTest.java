package com.ib.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SortedPermutationRankTest {

    @Parameterized.Parameters(name = "{index}: findRank({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"acb", 2},
                {"cab", 5},
                {"bca", 4},
                {"a", 1}
        });
    }

    private final String input;
    private final int expected;

    public SortedPermutationRankTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void findRank_returnsLexicographicRank() {
        SortedPermutationRank solution = new SortedPermutationRank();
        assertEquals(expected, solution.findRank(input));
    }
}
