package com.ib.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HotelBookingsPossibleTest {

  @Parameterized.Parameters(name = "{index}: hotel(...) = {3}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(1, 3, 5), Arrays.asList(2, 6, 8), 1, false},
          {Arrays.asList(1, 3, 5), Arrays.asList(2, 6, 8), 2, true},
          {Arrays.asList(), Arrays.asList(), 0, true}
        });
  }

  private final List<Integer> arrivals;
  private final List<Integer> departures;
  private final int rooms;
  private final boolean expected;

  public HotelBookingsPossibleTest(
      List<Integer> arrivals, List<Integer> departures, int rooms, boolean expected) {
    this.arrivals = arrivals;
    this.departures = departures;
    this.rooms = rooms;
    this.expected = expected;
  }

  @Test
  public void hotel_returnsWhetherBookingsCanBeAccommodated() {
    HotelBookingsPossible solution = new HotelBookingsPossible();
    assertEquals(expected, solution.hotel(arrivals, departures, rooms));
  }
}
