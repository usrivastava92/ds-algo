package com.ib.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrettyJsonTest {

    @Parameterized.Parameters(name = "{index}: prettyJSON(...)")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]",
                        Arrays.asList(
                                "[",
                                "\t\"foo\",",
                                "\t{",
                                "\t\t \"bar\":",
                                "\t\t[",
                                "\t\t\t\"baz\",",
                                "\t\t\tnull,",
                                "\t\t\t1.0,",
                                "\t\t\t2",
                                "\t\t]",
                                "\t}",
                                "]"
                        )
                },
                {
                        "{\"A\":\"B\"}",
                        Arrays.asList(
                                "{",
                                "\t\"A\":\"B\"",
                                "}"
                        )
                }
        });
    }

    private final String input;
    private final List<String> expected;

    public PrettyJsonTest(String input, List<String> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void prettyJSON_formatsIntoIndentedLines() {
        PrettyJson solution = new PrettyJson();
        assertEquals(new ArrayList<>(expected), solution.prettyJSON(input));
    }
}
