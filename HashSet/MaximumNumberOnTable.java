import java.util.*;

public class MaximumNumberOnTable {
    public static void main(String[] args) {
        System.out.println(maximumOnTable(new int[]{2,1,1,3,2,3}));
    }

//    TC: O(N)      SC: O(N)
    static int maximumOnTable(int[] nums) {
        Set<Integer> table = new HashSet<>();
        int count = 0;
        int maxCount = count;

        for (int i = 0; i < nums.length; i++) {
            if(!table.contains(nums[i])) {
                table.add(nums[i]);
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else {
                table.remove(nums[i]);
                count--;
            }
        }

        return maxCount;
    }
}
