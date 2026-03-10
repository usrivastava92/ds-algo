package com.patterns.structural.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdapterDemoTest {

    @Parameterized.Parameters(name = "{index}: adapt({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "utkarsh"},
                {42, "legacy"},
                {0, ""}
        });
    }

    private final int serialNumber;
    private final String displayName;

    public AdapterDemoTest(int serialNumber, String displayName) {
        this.serialNumber = serialNumber;
        this.displayName = displayName;
    }

    @Test
    public void adapter_exposesLegacyFieldsThroughNewInterface() {
        AdapterDemo demo = new AdapterDemo();
        assertEquals(serialNumber, demo.getId(serialNumber, displayName));
        assertEquals(displayName, demo.getName(serialNumber, displayName));
    }
}
