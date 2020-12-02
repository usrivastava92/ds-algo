package az.practice;

import org.junit.Assert;

import java.util.Arrays;
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
        int min = nums[0];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i < len; i++) {
            treeSet.add(nums[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            int a = min;
            int b = nums[i];
            Integer minC = treeSet.higher(min);
            Integer maxC = treeSet.lower(nums[i]);
            if (a < b && minC != null && maxC != null && minC <= maxC) {
                return true;
            }
            treeSet.remove(nums[i]);
            min = Math.min(min, nums[i]);
        }
        return false;
    }

}
