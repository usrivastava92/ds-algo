package com.prep.practice;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            Node next = curr.next;
            curr.next = clone;
            clone.next = next;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            Node random = curr.random;
            Node clone = curr.next;
            if (random != null) {
                clone.random = random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node cloneHead = head.next;
        while (curr != null) {
            Node clone = curr.next;
            Node oldNext = curr.next.next;
            if (oldNext != null) {
                curr.next = oldNext;
                clone.next = oldNext.next;
            } else {
                curr.next = null;
                clone.next = null;
            }
            curr = curr.next;
        }
        return cloneHead;
    }


    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
