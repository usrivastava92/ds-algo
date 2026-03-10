package com.ib.twopointers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveDuplicatesfromSortedArrayTest {

    @Parameterized.Parameters(name = "{index}: removeDuplicates({0}) -> {1}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(0, 0, 1, 1, 2, 2, 3), 4, Arrays.asList(0, 1, 2, 3)},
                {Arrays.asList(1, 1, 1, 1), 1, Arrays.asList(1)},
                {Arrays.asList(1, 2, 3), 3, Arrays.asList(1, 2, 3)}
        });
    }

    private final List<Integer> input;
    private final int expectedSize;
    private final List<Integer> expectedValues;

    public RemoveDuplicatesfromSortedArrayTest(List<Integer> input, int expectedSize, List<Integer> expectedValues) {
        this.input = input;
        this.expectedSize = expectedSize;
        this.expectedValues = expectedValues;
    }

    @Test
    public void removeDuplicates_compactsUniqueValuesInPlace() {
        RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();
        ArrayList<Integer> items = new ArrayList<>(input);
        assertEquals(expectedSize, solution.removeDuplicates(items));
        assertEquals(new ArrayList<>(expectedValues), items);
    }
}
