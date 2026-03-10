package com.ib.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SetMatrixZerosTest {

    @Parameterized.Parameters(name = "{index}: setZeroes(...)")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 1, 1}}, new int[][]{{0, 0, 0}, {1, 0, 1}, {1, 0, 1}}},
                {new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}}, new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 0, 0}}}
        });
    }

    private final int[][] input;
    private final int[][] expected;

    public SetMatrixZerosTest(int[][] input, int[][] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void setZeroes_zerosRowsAndColumnsInPlace() {
        SetMatrixZeros solution = new SetMatrixZeros();
        var arrayLists = ArrayUtils.toArrayList(input);
        solution.setZeroes(arrayLists);
        assertArrayEquals(expected, ArrayUtils.toArray(arrayLists));
    }
}
