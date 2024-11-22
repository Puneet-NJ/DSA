package Basic;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareArray(new int[]{-10, -3, -2, 1, 4, 5})));
    }

    // TC: O(N)     SC: O(1)
    static int[] squareArray(int[] nums) {
        int[] ans = new int[nums.length];
        int index = nums.length-1;
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int absLeft = Math.abs(nums[left]);
            int absRight = Math.abs(nums[right]);

            if(absLeft >= absRight) {
                ans[index--] = absLeft * absLeft;
                left++;
            }
            else {
                ans[index--] = absRight * absRight;
                right--;
            }
        }

        return ans;
    }
}
