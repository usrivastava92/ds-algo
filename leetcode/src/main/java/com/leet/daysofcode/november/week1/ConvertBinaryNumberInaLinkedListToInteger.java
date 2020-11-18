package com.leet.daysofcode.november.week1;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

import java.util.Arrays;

public class ConvertBinaryNumberInaLinkedListToInteger {

    public static void main(String[] args) {
        ConvertBinaryNumberInaLinkedListToInteger convertBinaryNumberInaLinkedListToInteger = new ConvertBinaryNumberInaLinkedListToInteger();
        for (int i = 0; i < 10; i++) {
            int[] binaryString = Arrays.stream(Integer.toBinaryString(i).split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Input : " + Arrays.toString(binaryString));
            System.out.println("Output : " + convertBinaryNumberInaLinkedListToInteger.getDecimalValue(LinkedListUtils.createList(binaryString)));
            System.out.println("Expected : " + i);
        }
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return -1;
        }
        int num = 0;
        while (head != null) {
            num = num << 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }

}
