package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

import java.io.IOException;

public class Carvans {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCase = reader.nextInt();
        for (int test = 0; test < testCase; test++) {
            int n = reader.nextInt();
            int maxPossible = reader.nextInt();
            int ans = 1;
            for (int i = 1; i < n; i++) {
                int carSpeed = reader.nextInt();
                if (carSpeed <= maxPossible) {
                    ans++;
                    maxPossible = carSpeed;
                }
            }
            System.out.println(ans);
        }
        reader.close();
    }

}
