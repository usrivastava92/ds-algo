package com.patterns.creational.builder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BuilderDemoTest {

    @Parameterized.Parameters(name = "{index}: buildValues({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, true, new String[]{"a", "b"}},
                {true, false, new String[]{"a", null}},
                {false, true, new String[]{null, "b"}},
                {false, false, new String[]{null, null}}
        });
    }

    private final boolean includeA;
    private final boolean includeB;
    private final String[] expected;

    public BuilderDemoTest(boolean includeA, boolean includeB, String[] expected) {
        this.includeA = includeA;
        this.includeB = includeB;
        this.expected = expected;
    }

    @Test
    public void buildValues_populatesConfiguredFields() {
        assertArrayEquals(expected, new BuilderDemo().buildValues(includeA, includeB));
    }
}
