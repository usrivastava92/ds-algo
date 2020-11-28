package az.practice;

import com.ds.linkedlist.LinkedListNode;
import com.ds.tree.BinaryTreeNode;
import com.ds.utils.ArrayUtils;
import com.ds.utils.SortingUtils;
import com.ds.utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.net.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 23, 5, 27, 21, 16, 23, 6, 7, 24, 10, 17, 27, 9, 16, 28, 28, 16, 19, 20);
        System.out.println(list);
        SortingUtils.quickSort(list);
        System.out.println(list);
    }

    public static int getNumDraws(int year) throws IOException {
        int sum = 0;
        for (int i =0; i<=10;i++){
            String uri = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1goals=%s&team2goals=%s",year,i,i);
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String line;
                StringBuilder json = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    json.append(line);
                }
                System.out.println(json.toString());
            }
        }
        return sum;
    }

    private static void sortLinkedList() {
        LinkedListNode<Integer> a = new LinkedListNode<>(1);
        LinkedListNode<Integer> b = new LinkedListNode<>(4);
        LinkedListNode<Integer> c = new LinkedListNode<>(7);
        LinkedListNode<Integer> d = new LinkedListNode<>(2);
        LinkedListNode<Integer> e = new LinkedListNode<>(4);
        LinkedListNode<Integer> f = new LinkedListNode<>(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
    }


    private static void sortTest() {
        List<Integer> list = Arrays.asList(ArrayUtils.generateRandomBoxedArray(10));
        System.out.println(list);
        SortingUtils.mergeSort(list);
        System.out.println(list);
    }

    private static void forLoopBenchmarking() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int start = 0;
        int end = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = start; i < end; i++) {
            list.add(random.nextInt(1000));
        }
        System.out.println("for loop insert time : " + (System.currentTimeMillis() - startTime) + " ms");
        list.clear();
        startTime = System.currentTimeMillis();
        IntStream.range(start, end).forEach(i -> list.add(random.nextInt()));
        System.out.println("stream insert time : " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void testTreeUtils() {
        BinaryTreeNode<Integer> head = TreeUtils.createRandomBST(10);
        TreeUtils.prettyPrintTree(head);
        System.out.println(TreeUtils.preorderTraversal(head));
        System.out.println(TreeUtils.postorderTraversal(head));
        System.out.println(TreeUtils.inorderTraversal(head));
        System.out.println(TreeUtils.getLevelOrderTraverseListLevelWise(head));
        System.out.println(TreeUtils.levelOrderTraverse(head));
    }


}
