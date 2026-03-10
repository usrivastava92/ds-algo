package com.patterns.behavioural.iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IteratorDemoTest {

    @Parameterized.Parameters(name = "{index}: values={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 3)},
                {Arrays.asList(5)},
                {Arrays.asList()}
        });
    }

    private final List<Integer> input;

    public IteratorDemoTest(List<Integer> input) {
        this.input = input;
    }

    @Test
    public void iteratorAndForEach_preserveInsertionOrder() {
        IteratorDemo demo = new IteratorDemo();
        assertEquals(input, demo.iterate(input));
        assertEquals(input, demo.forEachElements(input));
    }
}
