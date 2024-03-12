package Problems_On_Hashmaps;
import java.util.*;

public class Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(Approach2("aacc", "ccac"));

        // Approach1 ==> TC: O(N) SC: O(N)
        // Approach2 ==> TC: O(N) SC: O(N)  BUT ONLY 1 HASHMAP IS USED
    }

    static boolean Approach1(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        // Frequency check
        Map<Character, Integer> freqMap1 = getFreqMap(str1);
        Map<Character, Integer> freqMap2 = getFreqMap(str2);

        return freqMap1.equals(freqMap2);
    }
    static Map<Character, Integer> getFreqMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(freqMap.containsKey(str.charAt(i))) {
                freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
            }
            else {
                freqMap.put(str.charAt(i), 1);
            }
        }

        return freqMap;
    }


    static boolean Approach2(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        return checkAnag(str1, str2);
    }
    static boolean checkAnag(String str1, String str2) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            if(freqMap.containsKey(str1.charAt(i))) {
                freqMap.put(str1.charAt(i), freqMap.get(str1.charAt(i)) + 1);
            }
            else {
                freqMap.put(str1.charAt(i), 1);
            }
        }

        for(int i = 0; i < str2.length(); i++) {
            if(freqMap.containsKey(str2.charAt(i))) {
                freqMap.put(str2.charAt(i), freqMap.get(str2.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }

        for(var bucket: freqMap.entrySet()) {
            if(bucket.getValue() != 0) return false;
        }

        return true;
    }
}
