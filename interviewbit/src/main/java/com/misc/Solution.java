package com.misc;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the guestTable function below.
     */
    static int calculateDonation(PriorityQueue<PriorityQueue<Integer>> gener, PriorityQueue<PriorityQueue<Integer>> charm, int k) {

        int donation = 0;
        PriorityQueue<Integer> group = charm.poll();
        PriorityQueue<PriorityQueue<Integer>> bkp = new PriorityQueue<>(new SumArrComparator());
        Integer student = group.poll();
        int guestThisStudentCanAttend = k;
        while (!gener.isEmpty()) {
            PriorityQueue<Integer> table = gener.poll();
            if ((table.size() > (guestThisStudentCanAttend + (group.size() * k)))) {
                group.add(student);
                bkp.add(group);
                if (table.size() <= (bkp.peek().size() * k)) {
                    group = bkp.poll();
                    student = group.poll();
                    guestThisStudentCanAttend = k;
                } else {
                    group = charm.poll();
                    student = group.poll();
                    guestThisStudentCanAttend = k;
                }
            }
            while (!table.isEmpty()) {
                Integer guest = table.poll();
                if (guestThisStudentCanAttend == 0) {
                    guestThisStudentCanAttend = k;
                    student = group.poll();
                }
                System.out.println("guest & student -> " + guest + " " + student);
                donation += guest * student;
                guestThisStudentCanAttend--;
            }
        }
        return donation;
    }

    /*
     * Complete the solve function below.
     */
    private static int solve(int n, int k, int maxGuestInAGroup, PriorityQueue<PriorityQueue<Integer>> gener, PriorityQueue<PriorityQueue<Integer>> charm) {
        if (maxGuestInAGroup > (n * k)) {
            return -1;
        }
        return calculateDonation(gener, charm, k);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = Integer.parseInt(scanner.nextLine().trim());
        for (int tcItr = 0; tcItr < tc; tcItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0].trim());

            int n = Integer.parseInt(mn[1].trim());

            int t = Integer.parseInt(mn[2].trim());

            PriorityQueue<PriorityQueue<Integer>> charm = new PriorityQueue<>(new SumArrComparator());

            for (int charmRowItr = 0; charmRowItr < m; charmRowItr++) {
                String[] charmRowItems = scanner.nextLine().split(" ");
                PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
                for (int charmColumnItr = 0; charmColumnItr < n; charmColumnItr++) {
                    int charmItem = Integer.parseInt(charmRowItems[charmColumnItr].trim());
                    q.add(charmItem);
                }
                charm.add(q);
            }


            int maxGuestInAGroup = 0;
            PriorityQueue<PriorityQueue<Integer>> gener = new PriorityQueue<>(new SumArrComparator());
            for (int tItr = 0; tItr < t; tItr++) {
                String[] generositiesItems = scanner.nextLine().split(" ");
                int x = Integer.parseInt(generositiesItems[0]);
                if (x > maxGuestInAGroup) {
                    maxGuestInAGroup = x;
                }
                PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
                for (int generositiesItr = 1; generositiesItr < generositiesItems.length; generositiesItr++) {
                    int generositiesItem = Integer.parseInt(generositiesItems[generositiesItr].trim());
                    q.add(generositiesItem);
                }
                gener.add(q);
                //guestTable(generosities);
            }

            int k = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(solve(n, k, maxGuestInAGroup, gener, charm));
        }
    }

}

class SumArrComparator implements Comparator<PriorityQueue<Integer>> {
    @Override
    public int compare(PriorityQueue<Integer> o1, PriorityQueue<Integer> o2) {
        Integer sum1 = 0;
        Integer sum2 = 0;
        for (Integer i : o1) {
            sum1 += i;
        }
        for (Integer i : o2) {
            sum2 += i;
        }
        return sum2.compareTo(sum1);
    }
}
