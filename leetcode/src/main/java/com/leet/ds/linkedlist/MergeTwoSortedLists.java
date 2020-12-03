package com.leet.ds.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtils.createList(1, 2, 4);
        ListNode l2 = LinkedListUtils.createList(1, 3, 4);
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        System.out.println(LinkedListUtils.getTraversal(mergeTwoSortedLists.mergeTwoLists(l1, l2)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        ListNode returnNode = null;
        if (l1Pointer.val < l2Pointer.val) {
            returnNode = l1Pointer;
            l1Pointer = l1Pointer.next;
        } else {
            returnNode = l2Pointer;
            l2Pointer = l2Pointer.next;
        }
        ListNode curr = returnNode;
        curr.next = null;
        while (l1Pointer != null && l2Pointer != null) {
            if (l1Pointer.val < l2Pointer.val) {
                ListNode next = l1Pointer.next;
                curr.next = l1Pointer;
                curr = curr.next;
                curr.next = null;
                l1Pointer = next;
            } else {
                ListNode next = l2Pointer.next;
                curr.next = l2Pointer;
                curr = curr.next;
                curr.next = null;
                l2Pointer = next;
            }
        }
        while (l1Pointer != null) {
            ListNode next = l1Pointer.next;
            curr.next = l1Pointer;
            curr = curr.next;
            curr.next = null;
            l1Pointer = next;
        }
        while (l2Pointer != null) {
            ListNode next = l2Pointer.next;
            curr.next = l2Pointer;
            curr = curr.next;
            curr.next = null;
            l2Pointer = next;
        }
        return returnNode;
    }

}
