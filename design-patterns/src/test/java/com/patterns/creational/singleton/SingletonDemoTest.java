package com.patterns.creational.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class SingletonDemoTest {

    @Parameterized.Parameters(name = "{index}: repeated getInstance()")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1},
                {2}
        });
    }

    private final int ignored;

    public SingletonDemoTest(int ignored) {
        this.ignored = ignored;
    }

    @Test
    public void getInstance_returnsSameSingletonInstance() {
        assertSame(SingletonDemo.SingletonClass.getInstance(), SingletonDemo.SingletonClass.getInstance());
    }
}
