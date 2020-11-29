package com.leet.ds.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        ListNode[] list1s = {LinkedListUtils.createList(0, 1, 2, 3, 4, 5), LinkedListUtils.createList(0, 1, 2, 3, 4, 5, 6)};
        int[] as = {3, 2};
        int[] bs = {4, 5};
        ListNode[] list2s = {LinkedListUtils.createList(1000000, 1000001, 1000002), LinkedListUtils.createList(1000000, 1000001, 1000002, 1000003, 1000004)};
        ListNode[] outputs = {LinkedListUtils.createList(0, 1, 2, 1000000, 1000001, 1000002, 5), LinkedListUtils.createList(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6)};
        MergeInBetweenLinkedLists mergeInBetweenLinkedLists = new MergeInBetweenLinkedLists();
        IntStream.range(0, list1s.length).forEachOrdered(i -> {
            System.out.println("Input : list1 -> " + LinkedListUtils.getTraversal(list1s[i]) + ", list2 -> " + LinkedListUtils.getTraversal(list2s[i]) + ", a -> " + as[i] + ", b -> " + bs[i]);
            System.out.println("Output : " + LinkedListUtils.getTraversal(outputs[i]));
            Assert.assertEquals(outputs[i], mergeInBetweenLinkedLists.mergeInBetween(list1s[i], as[i], bs[i], list2s[i]));
        });
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        ListNode returnNode = list1;
        ListNode prevANode = null;
        ListNode bNode = null;
        while (list1 != null && list1.val != a) {
            prevANode = list1;
            list1 = list1.next;
        }
        if (prevANode == null) {
            returnNode = list2;
        } else {
            prevANode.next = list2;
        }
        bNode = getNode(list1, b);
        ListNode lastNodeOfList2 = getLastNode(list2);
        lastNodeOfList2.next = bNode.next;
        return returnNode;
    }

    public ListNode getLastNode(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

    public ListNode getNode(ListNode listNode, int target) {
        while (listNode != null && listNode.val != target) {
            listNode = listNode.next;
        }
        return listNode;
    }



}
