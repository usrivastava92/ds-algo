package com.gfg.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReorderListTest {

    @Test
    public void reorderList_reordersAlternatingFromFrontAndBack() {
        ReorderList solution = new ReorderList();
        Node head = LinkedListUtils.generateList(1, 2, 3, 4, 5);

        assertEquals(Arrays.asList(1, 5, 2, 4, 3), toList(solution.reorderList(head)));
    }

    private static List<Integer> toList(Node head) {
        ArrayList<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.data);
            head = head.next;
        }
        return values;
    }
}
