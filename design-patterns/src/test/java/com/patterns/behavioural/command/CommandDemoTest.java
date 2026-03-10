package com.patterns.behavioural.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CommandDemoTest {

    @Parameterized.Parameters(name = "{index}: ({0}, {1}) -> add={2}, multiply={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 4, 7, 12},
                {-2, 5, 3, -10},
                {0, 9, 9, 0}
        });
    }

    private final int left;
    private final int right;
    private final int expectedAdd;
    private final int expectedMultiply;

    public CommandDemoTest(int left, int right, int expectedAdd, int expectedMultiply) {
        this.left = left;
        this.right = right;
        this.expectedAdd = expectedAdd;
        this.expectedMultiply = expectedMultiply;
    }

    @Test
    public void commandOperations_returnExpectedResults() {
        CommandDemo demo = new CommandDemo();
        assertEquals(expectedAdd, demo.executeAdd(left, right));
        assertEquals(expectedMultiply, demo.executeMultiply(left, right));
    }
}
