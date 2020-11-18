package com.ib.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    public static void main(String... args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        two.next = three;

        one.random = three;
        two.random = one;
        three.random = one;

        printRandomList(one);
        CopyList copyList = new CopyList();
        RandomListNode randomListNode = copyList.copyRandomList(one);
        printRandomList(randomListNode);

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode node1 = head;
        RandomListNode node2 = newHead;

        map.put(node1, node2);
        node1 = node1.next;

        while(node1 != null) {
            RandomListNode temp = new RandomListNode(node1.label);
            map.put(node1, temp);
            node2.next = temp;
            node2 = node2.next;
            node1 = node1.next;
        }

        node1 = head;
        node2 = newHead;

        while(node1 != null) {
            if(node1.random != null) {
                node2.random = map.get(node1.random);
            }
            else {
                node2.random = null;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return newHead;
    }

    public static void printRandomList(RandomListNode randomListNode) {
        while (randomListNode != null) {
            System.out.print(randomListNode + " -> ");
            randomListNode = randomListNode.next;
        }
        System.out.print(null + " \n ############################### \n");
    }

}


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                '}';
    }
}