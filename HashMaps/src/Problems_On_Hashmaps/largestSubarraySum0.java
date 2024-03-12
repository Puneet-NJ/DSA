package Problems_On_Hashmaps;

import java.util.*;

public class largestSubarraySum0 {
    public static void main(String[] args) {
        System.out.println(betterApproach(new int[]{15, -2, 2, -8, 1, 7, 10, -25}));
    }

    static int practice(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        map.put(0, -1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = len > maxLen ? len : maxLen;
            }
            else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
    static int betterApproach(int[] arr) {
        int prefixSum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if(map.containsKey(prefixSum)) {
                int len = i - map.get(prefixSum);
                maxLen = Math.max(len, maxLen);
            }
            else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
