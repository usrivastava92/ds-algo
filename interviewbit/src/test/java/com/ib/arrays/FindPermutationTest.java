package com.ib.arrays;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FindPermutationTest {

  @Parameterized.Parameters(name = "{index}: findPerm({0}, {1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"ID", 3, Arrays.asList(1, 3, 2)},
          {"IIII", 5, Arrays.asList(1, 2, 3, 4, 5)},
          {"IDDID", 6, Arrays.asList(1, 6, 5, 2, 4, 3)}
        });
  }

  private final String pattern;
  private final int n;
  private final List<Integer> expected;

  public FindPermutationTest(String pattern, int n, List<Integer> expected) {
    this.pattern = pattern;
    this.n = n;
    this.expected = expected;
  }

  @Test
  public void findPerm_returnsPermutationMatchingPattern() {
    FindPermutation solution = new FindPermutation();
    ArrayList<Integer> actual = solution.findPerm(pattern, n);
    assertEquals(new ArrayList<>(expected), actual);
    FindPermutation.verifyOutput(actual, pattern, n);
  }
}
