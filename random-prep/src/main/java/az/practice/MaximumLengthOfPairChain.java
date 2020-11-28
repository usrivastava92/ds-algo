package az.practice;

import com.ds.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        int[][][] inputs = {{{2, 3}, {3, 4}, {1, 2}}, {{-2, 1}, {3, 7}, {0, 10}, {-1, 8}, {0, 7}, {8, 9}, {7, 10}, {-9, -3}, {-4, -3}, {0, 6}}, {{3, 4}, {2, 3}, {1, 2}}};
        int[] outputs = {2, 4, 2};
        MaximumLengthOfPairChain maximumLengthOfPairChain = new MaximumLengthOfPairChain();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i]));
            System.out.println("Output : " + maximumLengthOfPairChain.findLongestChain(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(pairs));
        int[] dp = new int[pairs.length];
        int globalMax = 1;
        for (int i = 0; i < dp.length; i++) {
            int max = 1;
            for (int j = i - 1; j > -1; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }

}
