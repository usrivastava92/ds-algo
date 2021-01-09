package com.leet.daysofcode.year2020.december.week1;

import com.leet.ds.linkedlist.ListNode;

import java.util.Random;

public class LinkedListRandomNode {

    public static void main(String[] args) {

    }


    private static final class Solution {

        private ListNode head;
        private ListNode curr;
        private static final Random RANDOM = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            curr = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int randomInt = getRandomInt(0, 10);
            while (randomInt-- > 0) {
                curr = curr.next;
                if (curr == null) {
                    curr = head;
                }
            }
            return curr.val;
        }

        public static int getRandomInt(int lowerLimitInclusive, int upperLimitInclusive) {
            return RANDOM.nextInt((++upperLimitInclusive) - lowerLimitInclusive) + lowerLimitInclusive;
        }


    }


}
