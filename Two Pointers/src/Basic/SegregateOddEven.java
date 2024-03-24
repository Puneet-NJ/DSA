package Basic;

import java.util.Arrays;

// Given an array of integers 'a', move all the even integers at the
//beginning of the array followed by all the odd integers. The
//relative order of odd or even integers does not matter. Return
//any array that satisfies the condition.
public class SegregateOddEven {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(segregate(nums)));
    }

//    TC: O(N)      SC: O(1)
    static int[] segregate(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right) {
            boolean leftEven = nums[left] % 2 == 0;
            boolean rightOdd = nums[right] % 2 == 1;

            if(!leftEven && !rightOdd) {
                swap(nums, left, right);
                left++;
                right--;
            }

            if(leftEven) left++;
            if(rightOdd) right--;
        }

        return nums;
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
