package az.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxContiguousSumInAnArray {

    public static void main(String[] args) {
        int[][] inputs = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {1}, {0}, {-1}};
        int[] outputs = {6, 1, 0, -1};
        MaxContiguousSumInAnArray maxContiguousSumInAnArray = new MaxContiguousSumInAnArray();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + maxContiguousSumInAnArray.maxSubArrayDivideAndConquer(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int maxTillNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxIncludingCurrent = maxTillNow + nums[i];
            maxTillNow = Math.max(maxIncludingCurrent, nums[i]);
            max = Math.max(max, maxTillNow);
        }
        return max;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = low + ((high - low) / 2);
        int leftMax = maxSubArray(nums, low, mid);
        int rightMax = maxSubArray(nums, mid + 1, high);
        int crossMax = crossMax(nums, low, high, mid);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossMax(int[] nums, int low, int high, int mid) {
        int lowerMax = nums[mid];
        int upperMax = nums[mid + 1];
        int lowerSum = nums[mid];
        int upperSum = nums[mid + 1];
        for (int i = mid - 1; i >= low; i--) {
            lowerSum += nums[i];
            lowerMax = Math.max(lowerSum, lowerMax);
        }
        for (int i = mid + 2; i <= high; i++) {
            upperSum += nums[i];
            upperMax = Math.max(upperSum, upperMax);
        }
        return lowerMax + upperMax;
    }

}
