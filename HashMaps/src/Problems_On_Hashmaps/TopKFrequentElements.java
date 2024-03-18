package Problems_On_Hashmaps;
import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }

    // TC: O(N)       SC: O(N)
    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], (map.get(nums[i]) + 1) );
            }
            else {
                map.put(nums[i], 1);
            }
        }

        ArrayList<Integer>[] bucketArray = new ArrayList[nums.length+1];

        for(var e: map.entrySet()) {
            if(bucketArray[e.getValue()] == null) bucketArray[e.getValue()] = new ArrayList<>();
            bucketArray[e.getValue()].add(e.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i = bucketArray.length-1; i >= 0; i--) {
            if(bucketArray[i] != null) {
                for(int j = 0; j < bucketArray[i].size(); j++) {
                    ans[index++] = bucketArray[i].get(j);
                    if(index == k) break;
                }
            }
            if(index == k) break;
        }

        return ans;
    }

    // TC: O(N + K*N)       SC: O(N)
    static public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        int[] ans = new int[k];
        int index = 0;
        int largest;
        int largestIndex;

        for(int i = 0; i < k; i++) {
            largest = Integer.MIN_VALUE;
            largestIndex = -1;
            for(var e: map.entrySet()) {
                if(e.getValue() > largest) {
                    largest = e.getValue();
                    largestIndex = e.getKey();
                }
            }
            ans[index++] = largestIndex;
            map.remove(largestIndex);
        }

        return ans;
    }

}
