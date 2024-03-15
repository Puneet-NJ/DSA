package Problems_On_Hashmaps;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
//        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        System.out.println(best(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    // TC: O(N * M)     SC: O(N)
    // where, m => avg. length of strings
    static public List<List<String>> best(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            int[] countArr = new int[26];

            for(int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                countArr[ch - 'a']++;
            }

            String countStr = Arrays.toString(countArr);

            if(map.containsKey(countStr)) {
                List<String> list = map.get(countStr);
                list.add(strs[i]);
                map.put(countStr, list);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(countStr, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(var e: map.entrySet()) {
            ans.add(e.getValue());
        }

        return ans;
    }

    // TC: O(N * N * M)     SC: O(N * N * M)
    // where, m => avg. length of strings
    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int[] arr = new int[strs.length];

        for(int i = 0; i < strs.length; i++) {
            if(arr[i] != 0) continue;

            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for(int j = i+1; j < strs.length; j++) {
                if(checkAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    arr[j] = 1;
                }
            }

            ans.add(list);
        }

        return ans;
    }
    static boolean checkAnagram(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
            }
            else {
                return false;
            }
        }

        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            if(e.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
