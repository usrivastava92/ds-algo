package com.patterns.creational.prototype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PrototypeDemoTest {

    @Parameterized.Parameters(name = "{index}: clone({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"A", "subclass"},
                {"demo", "nested"}
        });
    }

    private final String name;
    private final String subclassName;

    public PrototypeDemoTest(String name, String subclassName) {
        this.name = name;
        this.subclassName = subclassName;
    }

    @Test
    public void clone_createsDistinctObjectButSharesNestedReference() throws CloneNotSupportedException {
        PrototypeDemo demo = new PrototypeDemo();
        assertTrue(demo.isDistinctClone(name, subclassName));
        assertEquals(true, demo.sharesNestedReference(name, subclassName));
    }
}
