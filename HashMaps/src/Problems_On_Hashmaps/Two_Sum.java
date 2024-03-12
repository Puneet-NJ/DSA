package Problems_On_Hashmaps;

import java.util.*;

public class Two_Sum {
    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2,3,1,7,-1,-2,9}, 11);
        System.out.println(Arrays.toString(ans));
    }

    // TC: O(N)     SC: O(N)
    static public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int toSearch = target - nums[i];

            if(map.containsKey(toSearch)) {
                return new int[]{map.get(toSearch), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1};
    }
}
