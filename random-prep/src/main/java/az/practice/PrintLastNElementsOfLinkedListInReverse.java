package az.practice;

import com.ds.linkedlist.LinkedListNode;
import com.ds.utils.LinkedListUtils;

public class PrintLastNElementsOfLinkedListInReverse {

    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListUtils.generateRandomLinkedList(10);
        System.out.println(LinkedListUtils.getLinkedListAsString(head));
        recursiveSolution(head, 5);
    }

    private static <T> void solutionByReversingList(LinkedListNode<T> head, int n) {
        if (head == null) {
            return;
        }
        LinkedListNode<T> reverseHead = LinkedListUtils.reverseLinkedList(head);
        while (n-- > 0) {
            System.out.println(reverseHead);
            reverseHead = reverseHead.next;
        }
    }

    private static <T> int recursiveSolution(LinkedListNode<T> head, int n) {
        if (head == null) {
            return 0;
        }
        int returnVal = recursiveSolution(head.next, n);
        if (returnVal < n) {
            System.out.println(head);
        }
        return returnVal + 1;
    }

}
