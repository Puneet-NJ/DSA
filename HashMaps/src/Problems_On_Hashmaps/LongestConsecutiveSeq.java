package Problems_On_Hashmaps;

import java.util.*;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
    }

    // My method
    // TC: O(N log N)       SC: O(1)
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);
        int i = 0;
        int maxCount = 1;

        while(i < nums.length) {
            int count = 1;

            if(i < nums.length-1 && nums[i+1] == nums[i]+1) {
                while(i < nums.length-1 && (nums[i+1] == nums[i]+1 || nums[i+1] == nums[i])) {
                    i++;
                    if(i < nums.length-1 && nums[i+1] == nums[i]) continue;

                    count++;
                    maxCount = Math.max(count, maxCount);
                }
            }
            i++;
        }

        return maxCount;
    }

    //  TC: O(N)        SC: O(N)
    static public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(Integer e: set) {
            if(set.contains(e+1)) continue;  // Very important as it makes O(N^2) to O(N)
            int count = 1;
            maxCount = Math.max(count, maxCount);

            int j = e;
            while(set.contains(j-1)) {
                count++;
                maxCount = Math.max(count, maxCount);

                j -= 1;
            }
        }

        return maxCount;
    }
}
