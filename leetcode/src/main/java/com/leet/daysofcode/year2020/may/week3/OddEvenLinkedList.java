package com.leet.daysofcode.year2020.may.week3;


import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode[] heads = {LinkedListUtils.createList(1, 2, 3, 4, 5), LinkedListUtils.createList(2, 1, 3, 5, 6, 4, 7), LinkedListUtils.createList(2, 1, 3, 5, 6, 4)};

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        for (ListNode head : heads) {
            System.out.println("Input : " + head);
            System.out.println("Output : " + oddEvenLinkedList.oddEvenList(head));
        }

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode currOdd = head;
        ListNode even = head.next;
        ListNode append = even;
        ListNode currEven = head.next;
        while (currOdd != null && currOdd.next != null && currEven != null && currEven.next != null) {
            currOdd = currOdd.next.next;
            currEven = currEven.next.next;
            odd.next = currOdd;
            even.next = currEven;
            odd = odd.next;
            even = even.next;
        }
        odd.next = append;
        return head;
    }

}
