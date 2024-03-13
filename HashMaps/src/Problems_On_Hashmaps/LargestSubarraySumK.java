package Problems_On_Hashmaps;

import java.util.HashMap;

public class LargestSubarraySumK {
    public static void main(String[] args) {
        int[] nums = {2,0,0,3};
        int target = 2;

        System.out.println(longestSubarrayWithSumK(nums, target));
    }

    // WORKS FOR BOTH POSITIVE & NEGATIVE
    static int hashmap(int[] nums, int target) {
        // Optimal approach: TC: O(N)   SC: O(N)
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - target)) {
                int len = i - map.get(prefixSum - target);
                maxLen = Math.max(len, maxLen);
            }

            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    // WORKS FOR ONLY POSITIVE
    // Optimal approach: TC: O(N)   SC: O(1)
    public static int longestSubarrayWithSumK(int []nums, long k) {
        int i = 0;
        int j = 0;
        long sum = nums[i];
        int maxLen = 0;

        while(j < nums.length) {
            if(sum == k) {
                maxLen = Math.max(maxLen, j-i+1);
            }

            if(sum <= k) {
                j++;
                if(j == nums.length) break;
                sum += nums[j];
            }

            else if(sum > k) {
                sum -= nums[i];
                i++;
            }
        }
        if(j == nums.length) {
            while(sum >= k) {
                sum -= nums[i];
                i++;
            }
        }

        return maxLen;
    }
}
