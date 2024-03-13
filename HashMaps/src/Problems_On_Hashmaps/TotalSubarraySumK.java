package Problems_On_Hashmaps;

import java.util.*;

public class TotalSubarraySumK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    //  TC: O(N)        SC: O(N)
   static public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            int countToPut = (map.get(prefixSum) == null) ? 1 : (map.get(prefixSum) + 1);
            map.put(prefixSum, countToPut);
        }

        return count;
    }
}
