package az.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveElement {

    public static void main(String[] args) {
        int[][] inputs = {{3, 2, 2, 3}, {0, 1, 2, 2, 3, 0, 4, 2}, {1, 2, 2, 3}, {1}, {1}, {3, 3}, {4, 5}};
        int[] vals = {3, 2, 3, 1, 2, 3, 4};
        int[] outputs = {2, 5, 3, 0, 1, 0, 1};
        RemoveElement removeElement = new RemoveElement();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + " val : " + vals[i]);
            System.out.println("Output : " + removeElement.removeElement(inputs[i], vals[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }


    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int size = nums.length;
        while (i < size) {
            if (nums[i] == val) {
                swap(nums, i, size - 1);
                size--;
            } else {
                i++;
            }
        }
        return size;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
