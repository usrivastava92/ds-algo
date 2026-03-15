package com.ib.twopointers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RemoveElementFromArrayTest {

  @Parameterized.Parameters(name = "{index}: removeElement({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {Arrays.asList(4, 1, 1, 2, 1, 3), 1, 3, Arrays.asList(4, 2, 3)},
          {Arrays.asList(1, 1, 1), 1, 0, Arrays.asList()},
          {Arrays.asList(2, 3, 4), 1, 3, Arrays.asList(2, 3, 4)}
        });
  }

  private final List<Integer> input;
  private final int valueToRemove;
  private final int expectedLength;
  private final List<Integer> expectedPrefix;

  public RemoveElementFromArrayTest(
      List<Integer> input, int valueToRemove, int expectedLength, List<Integer> expectedPrefix) {
    this.input = input;
    this.valueToRemove = valueToRemove;
    this.expectedLength = expectedLength;
    this.expectedPrefix = expectedPrefix;
  }

  @Test
  public void removeElement_movesKeptValuesToFront() {
    RemoveElementFromArray solution = new RemoveElementFromArray();
    ArrayList<Integer> values = new ArrayList<>(input);
    int actualLength = solution.removeElement(values, valueToRemove);
    assertEquals(expectedLength, actualLength);
    assertEquals(new ArrayList<>(expectedPrefix), new ArrayList<>(values.subList(0, actualLength)));
  }
}
