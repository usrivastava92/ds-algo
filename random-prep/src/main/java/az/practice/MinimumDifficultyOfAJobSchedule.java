package az.practice;

import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {

    public static void main(String[] args) {
        MinimumDifficultyOfAJobSchedule minimumDifficultyOfAJobSchedule = new MinimumDifficultyOfAJobSchedule();
        System.out.println(minimumDifficultyOfAJobSchedule.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 2; i <= d; ++i) {
            for (int j = 0; j <= n - i; ++j) {
                int maxd = 0;
                dp[j] = Integer.MAX_VALUE;
                for (int k = j; k <= n - i; ++k) {
                    maxd = Math.max(maxd, jobDifficulty[k]);
                    dp[j] = Math.min(dp[j], maxd + dp[k + 1]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

}
