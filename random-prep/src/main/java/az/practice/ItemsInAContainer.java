package az.practice;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ItemsInAContainer {

    public static void main(String[] args) {
        String[] s = {"*|*|", "|**|*|*"};
        int[][] starts = {{1}, {1, 1, 5}};
        int[][] ends = {{3}, {5, 6, 7}};
        int[][] outputs = {{0}, {2, 3, 0}};
        ItemsInAContainer itemsInAContainer = new ItemsInAContainer();
        IntStream.range(0, s.length).forEachOrdered(i -> {
            System.out.println("Input : " + s[i] + " starts : " + Arrays.toString(starts[i]) + " ends : " + Arrays.toString(ends[i]));
            int[] ans = itemsInAContainer.getItem(s[i], starts[i], ends[i]);
            System.out.println("Output : " + Arrays.toString(ans));
            Assert.assertArrayEquals(outputs[i], ans);
        });
    }

    public int[] getItem(String s, int[] starts, int[] ends) {
        if (s == null || starts == null || ends == null || starts.length == 0 || ends.length == 0) {
            return new int[]{};
        }
        int len = s.length();
        int[] dp = new int[len];
        int i = 0;
        int totalTillNow = 0;
        while (s.charAt(i) != '|') {
            dp[i] = totalTillNow;
            i++;
        }
        int temp = 0;
        for (; i < len; i++) {
            if (s.charAt(i) == '*') {
                temp++;
            } else if (s.charAt(i) == '|') {
                totalTillNow += temp;
                temp = 0;
            }
            dp[i] = totalTillNow;
        }
        System.out.println("dp : " + Arrays.toString(dp));
        int[] ans = new int[starts.length];
        for (i = 0; i < starts.length; i++) {
            int start = starts[i] - 1;
            int end = ends[i] - 1;
            while (s.charAt(start) == '*') {
                start++;
            }
            while (s.charAt(end) == '*') {
                end--;
            }
            if (start >= end) {
                ans[i] = 0;
            } else {
                ans[i] = dp[end] - dp[start];
            }
        }
        return ans;
    }

}
