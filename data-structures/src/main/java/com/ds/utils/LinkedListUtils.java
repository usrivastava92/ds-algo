package com.ds.utils;

import com.ds.linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LinkedListUtils {

    private LinkedListUtils() {
    }

    public static <T extends Comparable<T>> LinkedListNode<T> sort(LinkedListNode<T> head) {
        return sort(head, Comparable::compareTo);
    }

    public static <T> LinkedListNode<T> sort(LinkedListNode<T> head, Comparator<T> comparator) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = length(head);
        for (int i = 2; i <= len; i *= 2) {
            for (int j = 1; j <= len; j += i) {

            }
        }
        return null;
    }

    public static <T> Optional<LinkedListNode<T>> getNode(LinkedListNode<T> head, int index) {
        if (head == null) {
            return Optional.empty();
        }
        if (index < 0) {
            return Optional.empty();
        }
        int temp = 0;
        while (temp < index && head != null) {
            head = head.next;
            temp++;
        }
        if (temp != index) {
            return Optional.empty();
        }
        return Optional.ofNullable(head);
    }

    private static <T> void merge(LinkedListNode<T> head, Comparator<T> comparator, int low, int mid, int high) {
        if (head == null) {
            return;
        }
        LinkedListNode<T> head1 = head;
        Optional<LinkedListNode<T>> optionalHead2 = getNode(head, mid + 1);
        if (!optionalHead2.isPresent()) {
            return;
        }
        LinkedListNode<T> head2 = optionalHead2.get();
        LinkedListNode<T> curr = new LinkedListNode<T>(head1.val);
        int index1 = low;
        int index2 = mid + 1;
        while (head1 != null && head2 != null && index1 <= mid && index2 <= high) {
            if (comparator.compare(head1.val, head2.val) < 0) {
                curr.next = head1;
                head1 = head1.next;
                index1++;
            } else {
                curr.next = head2;
                head2 = head2.next;
                index2++;
            }
            curr = curr.next;
        }
        while (head1 != null && index1 <= mid) {
            curr.next = head1;
            curr = curr.next;
            head1 = head1.next;
            index1++;
        }
        while (head2 != null && index2 <= high) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
            index2++;
        }
    }

    public static <T> int length(LinkedListNode<T> node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static <T> LinkedListNode<Integer> generateRandomLinkedList(int size) {
        if (size <= 0) {
            return null;
        }
        int lowerLimit = 10;
        int upperLimit = 100;
        LinkedListNode<Integer> head = new LinkedListNode<>(NumberUtils.getRandomInt(lowerLimit, upperLimit));
        LinkedListNode<Integer> current = head;
        for (int i = 1; i < size; i++) {
            current.next = new LinkedListNode<>(NumberUtils.getRandomInt(lowerLimit, upperLimit));
            current = current.next;
        }
        return head;
    }

    public static <T> String getLinkedListAsString(LinkedListNode<T> head) {
        List<T> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toString();
    }

    public static <T> LinkedListNode<T> reverseLinkedList(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        while (head != null) {
            LinkedListNode<T> temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
