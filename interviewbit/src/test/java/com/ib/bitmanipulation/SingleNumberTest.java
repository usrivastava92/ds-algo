package com.ib.bitmanipulation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SingleNumberTest {

    @Parameterized.Parameters(name = "{index}: singleNumber({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 2, 3, 1), 3},
                {Arrays.asList(4, 1, 2, 1, 2), 4},
                {Arrays.asList(9), 9}
        });
    }

    private final List<Integer> input;
    private final int expected;

    public SingleNumberTest(List<Integer> input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void singleNumber_returnsTheUniqueElement() {
        SingleNumber solution = new SingleNumber();
        assertEquals(expected, solution.singleNumber(input));
    }
}
