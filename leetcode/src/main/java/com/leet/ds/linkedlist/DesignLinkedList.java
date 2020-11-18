package com.leet.ds.linkedlist;

public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));            // returns 3
    }

}

class MyLinkedList {

    private class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = head;
        int i = 0;
        while (node != null && i < index) {
            node = node.next;
            i++;
        }
        if (node == null) {
            return -1;
        }
        return node.data;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        if (head == null) {
            tail = listNode;
        }
        head = listNode;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val);
        tail.next = listNode;
        tail = listNode;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode node = head;
        int i = 0;
        index--;
        while (node != null && i < index) {
            node = node.next;
            i++;
        }
        if (node == tail) {
            addAtTail(val);
            return;
        }
        if (node != null) {
            ListNode temp = node.next;
            node.next = new ListNode(val);
            node.next.next = temp;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
            return;
        }
        ListNode node = head;
        int i = 0;
        index--;
        while (node != null && i < index) {
            node = node.next;
            i++;
        }
        if (node != null && node.next != null) {
            if (node.next == tail) {
                tail = node;
            }
            node.next = node.next.next;
        }
    }
}
