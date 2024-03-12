package Problems_On_Hashmaps;

import java.util.*;

public class Contains_Duplicates {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    // TC: O(N)     SC: O(N)
    static public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return true;

            map.put(nums[i], 1);
        }

        return false;
    }
}
