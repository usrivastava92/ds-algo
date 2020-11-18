package az.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DeleteAndEarn {

    public static void main(String[] args) {
        int[][] inputs = {{3, 4, 2}, {2, 2, 3, 3, 3, 4}};
        int[] outputs = {6, 9};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + deleteAndEarn.deleteAndEarn(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[10001];
        for (int num : nums) {
            dp[num] += num;
        }
        int maxIfDeletePrev = 0;
        int maxIfNotDeletePrev = 0;
        for (int num : dp) {
            int ifDeleteCurrent = maxIfNotDeletePrev + num;
            int ifNotDeleteCurrent = Math.max(maxIfDeletePrev, maxIfNotDeletePrev);
            maxIfDeletePrev = ifDeleteCurrent;
            maxIfNotDeletePrev = ifNotDeleteCurrent;
        }
        return Math.max(maxIfDeletePrev, maxIfNotDeletePrev);
    }

}
