package com.ib.greedy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MeetingRoomsTest {

    @Parameterized.Parameters(name = "{index}: solve(...) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{0, 30}, {5, 10}, {15, 20}}, 2},
                {new int[][]{{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}}, 4},
                {new int[][]{{7, 10}, {4, 19}, {19, 26}, {14, 16}, {13, 18}, {16, 21}}, 3},
                {new int[][]{{0, 14}, {6, 25}, {12, 19}, {13, 19}, {5, 9}}, 4},
                {new int[][]{}, 0},
                {null, 0}
        });
    }

    private final int[][] input;
    private final int expected;

    public MeetingRoomsTest(int[][] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void solve_returnsMinimumRoomsRequired() {
        MeetingRooms solution = new MeetingRooms();
        assertEquals(expected, solution.solve(input));
    }
}
