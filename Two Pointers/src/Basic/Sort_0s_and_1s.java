package Basic;

import java.util.*;

public class Sort_0s_and_1s {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,0,1,1,0,0}; // 5 0s and 4 1s
        System.out.println(Arrays.toString(sort_2Pointers(nums)));
    }

    static int[] sort_2Pointers(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            if(nums[left] == 1 && nums[right] == 0) {
                swap(nums, left, right);
                left++;
                right--;
            }
            if(nums[left] == 0) {
                left++;
            }
            if(nums[right] == 1) {
                right--;
            }
        }

        return nums;
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int[] sort(int[] nums) {
        int zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i < zeros) nums[i] = 0;
            else nums[i] = 1;
        }

        return nums;
    }
}
