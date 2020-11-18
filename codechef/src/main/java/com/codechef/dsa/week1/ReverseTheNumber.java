package com.codechef.dsa.week1;

import java.util.Scanner;

public class ReverseTheNumber {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while(testCases-- > 0){
            System.out.println(Integer.parseInt(new StringBuffer(sc.nextLine()).reverse().toString()));
        }
        sc.close();
    }

}
