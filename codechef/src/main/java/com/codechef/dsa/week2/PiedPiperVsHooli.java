package com.codechef.dsa.week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PiedPiperVsHooli {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        while (testCases-- > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            long n = Integer.valueOf(input[0]);
            long a = Integer.valueOf(input[1]);
            long b = Integer.valueOf(input[2]);
            long x = Integer.valueOf(input[3]);
            long y = Integer.valueOf(input[4]);
            long z = Integer.valueOf(input[5]);
            long na = -1;
            long temp = z - a;
            if (temp % x == 0) {
                na = temp / x;
            } else {
                na = (temp / x) + 1;
            }
            long nb = -1;
            temp = z - b;
            if (temp % y == 0) {
                nb = temp / y;
            } else {
                nb = (temp / y) + 1;
            }
            if (na < nb) {
                sc.nextLine();
                System.out.println(0);
            } else {
                PriorityQueue<Long> pqueue = new PriorityQueue<>(Collections.reverseOrder());
                String[] nums = sc.nextLine().trim().split(" ");
                for (String num : nums) {
                    pqueue.add(Long.parseLong(num));
                }
                long leftToReach = z - (a + ((nb - 1) * x));
                calculateContribution(pqueue, leftToReach);
            }
        }
        sc.close();
    }

    private static void calculateContribution(PriorityQueue<Long> pqueue, long leftToReach) {
        int noOfContribution = 0;
        while (leftToReach > 0 && !pqueue.isEmpty()) {
            long poll = pqueue.poll();
            System.out.println("contribution -> " + poll);
            leftToReach -= poll;
            poll = poll / 2;
            if (poll != 0) {
                pqueue.add(poll);
            }
            noOfContribution++;
        }
        if (leftToReach > 0) {
            System.out.println("RIP");
        } else {
            System.out.println(noOfContribution);
        }
    }


}
