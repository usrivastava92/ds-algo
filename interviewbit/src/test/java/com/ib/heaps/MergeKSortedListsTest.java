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
public class MergeKSortedListsTest {

  @Parameterized.Parameters(name = "{index}: mergeKLists(...) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {
            Arrays.asList(Arrays.asList(1, 4, 5), Arrays.asList(1, 3, 4), Arrays.asList(2, 6)),
            Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6)
          },
          {Arrays.asList(Arrays.asList(1), Arrays.asList(0)), Arrays.asList(0, 1)},
          {Arrays.asList(), Arrays.asList()}
        });
  }

  private final List<List<Integer>> input;
  private final List<Integer> expected;

  public MergeKSortedListsTest(List<List<Integer>> input, List<Integer> expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void mergeKLists_mergesAllListsInSortedOrder() {
    MergeKSortedLists solution = new MergeKSortedLists();
    ArrayList<ListNode> lists = new ArrayList<>();
    for (List<Integer> values : input) {
      lists.add(toList(values));
    }
    assertEquals(expected, fromList(solution.mergeKLists(lists)));
  }

  private static ListNode toList(List<Integer> values) {
    ListNode head = null;
    ListNode tail = null;
    for (int value : values) {
      ListNode node = new ListNode(value);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
    }
    return head;
  }

  private static List<Integer> fromList(ListNode head) {
    ArrayList<Integer> values = new ArrayList<>();
    while (head != null) {
      values.add(head.val);
      head = head.next;
    }
    return values;
  }
}
