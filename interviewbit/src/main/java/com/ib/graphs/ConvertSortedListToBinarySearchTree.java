package com.ib.graphs;

import com.ib.linkedlist.LinkedListUtils;
import com.ib.linkedlist.ListNode;
import com.ib.tree.TreeNode;
import com.ib.tree.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode listNode = LinkedListUtils.generateLinkedList(2, 4, 6, 10, 16, 17, 21, 27, 31, 38, 39, 40, 45, 48, 50, 51, 52, 57, 64, 67, 68, 71, 79, 83, 85, 86, 87, 94, 96, 97, 102, 107, 109, 126, 130, 136, 138, 149, 154, 155, 157, 162, 179, 183, 194, 198, 207, 214, 221, 232, 236, 239, 247, 253, 270, 272, 275, 292, 301, 302, 303, 315, 320, 325, 329, 333, 336, 340, 343, 349, 353, 360, 364, 366, 371, 384, 386, 387, 389, 390, 392, 399, 401, 402, 411, 418, 434, 437, 440, 442, 448, 450, 451, 456, 464, 466, 469, 475, 480, 482, 483, 488, 493, 497, 499, 501, 502, 508, 512, 515, 519, 524, 537, 552, 558, 569, 574, 575, 580, 584, 585, 591, 595, 601, 602, 611, 621, 623, 628, 635, 642, 645, 655, 665, 676, 684, 687, 693, 699, 705, 717, 725, 728, 729, 731, 763, 766, 768, 773, 791, 797, 799, 807, 812, 829, 848, 862, 863, 868, 877, 878, 889, 893, 898, 901, 909, 910, 911, 914, 916, 925, 928, 930, 936, 937, 952, 955, 967, 969, 978, 982, 986, 990, 993, 994, 995, 1004, 1008, 1022, 1026, 1030, 1032, 1033, 1041, 1050);
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        System.out.println(TreeUtils.inorderTraversal(convertSortedListToBinarySearchTree.sortedListToBST(listNode)));
    }

    public TreeNode sortedListToBST(ListNode a) {
        if (a == null) {
            return null;
        }
        if (a.next == null) {
            return new TreeNode(a.val);
        }
        List<Integer> list = new ArrayList<>();
        ListNode curr = a;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return makeTree(list, 0, list.size() - 1);
    }

    public TreeNode makeTree(List<Integer> list, int low, int high) {
        if (low > high || low < 0 || high >= list.size()) {
            return null;
        }
        if (low == high) {
            return new TreeNode(list.get(low));
        }
        int mid = low + (high - low) / 2;
        TreeNode head = new TreeNode(list.get(mid));
        head.left = makeTree(list, low, mid - 1);
        head.right = makeTree(list, mid + 1, high);
        return head;
    }


}
