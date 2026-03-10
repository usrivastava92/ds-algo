package com.ib.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PossibilityOfFinishingAllCoursesGivenPreRequisitesTest {

    @Parameterized.Parameters(name = "{index}: solve({0}, ...) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, new int[]{1, 2}, new int[]{2, 3}, 1},
                {2, new int[]{1, 2}, new int[]{2, 1}, 0},
                {32, new int[]{}, new int[]{}, 1}
        });
    }

    private final int courses;
    private final int[] prereqFrom;
    private final int[] prereqTo;
    private final int expected;

    public PossibilityOfFinishingAllCoursesGivenPreRequisitesTest(int courses, int[] prereqFrom, int[] prereqTo, int expected) {
        this.courses = courses;
        this.prereqFrom = prereqFrom;
        this.prereqTo = prereqTo;
        this.expected = expected;
    }

    @Test
    public void solve_returnsWhetherAllCoursesCanBeFinished() {
        PossibilityOfFinishingAllCoursesGivenPreRequisites solution = new PossibilityOfFinishingAllCoursesGivenPreRequisites();
        assertEquals(expected, solution.solve(courses, prereqFrom, prereqTo));
    }
}
