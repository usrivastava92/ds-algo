package com.codechef.dsa.week1;

import java.util.Scanner;

public class LifeTheUniverseAndEverything {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num!=42){
            System.out.println(num);
            num = sc.nextInt();
        }
        sc.close();
    }

}
