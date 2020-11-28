package com.codechef.dsa.week2;

import java.util.Scanner;

public class PenaltyShootOutII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String shots = sc.nextLine();
            int totalShots = n * 2;
            int successfulShotByA = 0;
            int failedShotByA = 0;
            int successfulShotByB = 0;
            int failedShotByB = 0;
            int ans = -1;
            for (int shotIndex = 0; shotIndex < totalShots; shotIndex++) {
                int shot = Integer.parseInt(shots.substring(shotIndex, shotIndex + 1));
                if (shotIndex % 2 == 0) {
                    if (shot == 0) {
                        failedShotByA++;
                    } else {
                        successfulShotByA++;
                    }
                } else {
                    if (shot == 0) {
                        failedShotByB++;
                    } else {
                        successfulShotByB++;
                    }
                }
                int shotLeftForA = n - (successfulShotByA + failedShotByA);
                int shotLeftForB = n - (successfulShotByB + failedShotByB);
                if ((successfulShotByB > (successfulShotByA + shotLeftForA)) || (successfulShotByA > (successfulShotByB + shotLeftForB))) {
                    ans = shotIndex;
                    break;
                }
            }
            if (ans == -1) {
                ans = totalShots;
            } else {
                ans += 1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
