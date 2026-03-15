package com.ib.heaps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MagicianAndChocolatesTest {

  @Parameterized.Parameters(name = "{index}: nchoc({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {3, Arrays.asList(6, 5), 14},
          {2, Arrays.asList(2, 4, 6), 10},
          {0, Arrays.asList(1, 2), 0}
        });
  }

  private final int turns;
  private final List<Integer> bags;
  private final int expected;

  public MagicianAndChocolatesTest(int turns, List<Integer> bags, int expected) {
    this.turns = turns;
    this.bags = bags;
    this.expected = expected;
  }

  @Test
  public void nchoc_returnsMaximumChocolatesEaten() {
    MagicianAndChocolates solution = new MagicianAndChocolates();
    assertEquals(expected, solution.nchoc(turns, new ArrayList<>(bags)));
  }
}
