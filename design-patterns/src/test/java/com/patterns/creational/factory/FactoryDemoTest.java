package com.patterns.creational.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FactoryDemoTest {

    @Parameterized.Parameters(name = "{index}: getProductType({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "ObjectA"},
                {2, "ObjectB"},
                {3, null}
        });
    }

    private final int input;
    private final String expected;

    public FactoryDemoTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void getProductType_returnsExpectedConcreteType() {
        assertEquals(expected, new FactoryDemo().getProductType(input));
    }
}
