package Problems_On_Hashmaps;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf3(new int[]{1,2,3,4})));
    }

    //    TC: O(N)    SC: O(1)
    static public int[] productExceptSelf3(int[] nums) {
        int[] ans = new int[nums.length];
        int prefixProduct = 1;

        ans[0] = 1;
        for(int i = 0; i < nums.length-1; i++) {
            prefixProduct *= nums[i];
            ans[i+1] = prefixProduct;
        }

        int postfixProduct = 1;
        ans[nums.length-1] *= 1;
        for(int i = nums.length-1; i >= 1; i--) {
            postfixProduct *= nums[i];
            ans[i-1] *= postfixProduct;
        }

        return ans;
    }

    //    TC: O(N)    SC: O(N)
    static int[] productExceptSelf2(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];

        prefixProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i];
        }

        postfixProduct[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            postfixProduct[i] = postfixProduct[i+1] * nums[i];
        }

        int[] ans = new int[nums.length];
        ans[0] = postfixProduct[1];
        ans[nums.length-1] = prefixProduct[nums.length-2];
        for (int i = 1; i < ans.length-1; i++) {
            ans[i] = prefixProduct[i-1] * postfixProduct[i+1];
        }

        return ans;
    }

//    TC: O(N*N)    SC: O(1)
    static public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = 0; j < nums.length; j++) {
                if(j == i) continue;

                product *= nums[j];
            }
            ans[index++] = product;
        }

        return ans;
    }
}
