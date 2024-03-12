package Problems_On_Hashmaps;

import java.util.HashMap;

public class LargestSubarraySumK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,1,1,4,2,3};
        int target = 3;

        System.out.println(hashmap(nums, target));
    }

    static int hashmap(int[] nums, int target) {
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - target)) {
                int len = i - map.get(prefixSum - target);
                maxLen = Math.max(len, maxLen);
            }

            map.put(prefixSum, i);
        }

        return maxLen;
    }
}
