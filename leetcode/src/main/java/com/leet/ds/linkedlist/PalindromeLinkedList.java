package com.leet.ds.linkedlist;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createList(1, 2, 2, 1);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        System.out.println(head);
        if (head == null || head.next==null) {
            return true;
        }
        int len = 0;
        ListNode trav = head;
        while (trav != null) {
            len++;
            trav = trav.next;
        }
        int mid = (len / 2) + 1;
        ListNode secondHalf = head;
        while (mid-- > 1) {
            secondHalf = secondHalf.next;
        }
        secondHalf = LinkedListUtils.reverseList(secondHalf);
        System.out.println(secondHalf);
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

}
