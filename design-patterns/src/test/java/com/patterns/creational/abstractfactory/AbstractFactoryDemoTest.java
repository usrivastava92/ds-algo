package com.patterns.creational.abstractfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AbstractFactoryDemoTest {

    @Parameterized.Parameters(name = "{index}: getProductType({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, "ObjectC"},
                {1, 2, "ObjectD"},
                {2, 1, "ObjectA"},
                {2, 2, "ObjectB"},
                {3, 1, null},
                {1, 3, null}
        });
    }

    private final int factoryType;
    private final int productType;
    private final String expected;

    public AbstractFactoryDemoTest(int factoryType, int productType, String expected) {
        this.factoryType = factoryType;
        this.productType = productType;
        this.expected = expected;
    }

    @Test
    public void getProductType_returnsExpectedConcreteProduct() {
        assertEquals(expected, new AbstractFactoryDemo().getProductType(factoryType, productType));
    }
}
