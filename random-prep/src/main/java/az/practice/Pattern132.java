package az.practice;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Pattern132 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {3, 1, 4, 2}, {-1, 3, 2, 0}, {-2, 1, 2, -2, 1, 2}};
        boolean[] outputs = {false, true, true, true};
        Pattern132 pattern132 = new Pattern132();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(nums[i]));
            boolean output = pattern132.find132pattern(nums[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int[] mins = new int[len];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > mins[i]) {
                while (!stack.isEmpty() && stack.peek() <= mins[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

}
