package az.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[][] inputs = {{1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}, {1}, {}};
        int[] targets = {5, 2, 7, 0, 1,1};
        int[] outputs = {2, 1, 4, 0, 0,0};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + " target : " + targets[i]);
            System.out.println("Output : " + searchInsertPosition.searchInsert(inputs[i], targets[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
