package com.patterns.behavioural.chainofresponsibility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ChainOfResponsibilityDemoTest {

    @Parameterized.Parameters(name = "{index}: sanctionLoan({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {99, "Loan sanctioned by Cashier"},
                {150, "Loan sanctioned by Manager"},
                {210, "Loan sanctioned by BranchManager"}
        });
    }

    private final int amount;
    private final String expected;

    public ChainOfResponsibilityDemoTest(int amount, String expected) {
        this.amount = amount;
        this.expected = expected;
    }

    @Test
    public void sanctionLoan_routesToExpectedApprover() {
        assertEquals(expected, new ChainOfResponsibilityDemo().sanctionLoan(amount));
    }
}
