package Problems_On_Hashmaps;

import java.util.*;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        System.out.println(thirdApproach("aab", "xxy"));
    }

    static boolean myApproach(String str1, String str2) {
        return map(str1, str2) && map(str2, str1);
    }
    static boolean map(String str1, String str2) {
        Map<Character, Character> mp = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(mp.containsKey(ch1) && mp.get(ch1) != ch2) {
                return false;
            }


            mp.put(ch1, ch2);
        }

        return true;
    }

    static boolean betterApproach(String str1, String str2) {
        Map<Character, Character> mp = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(mp.containsKey(ch1)){
                if(mp.get(ch1) != ch2) return false;
            }
            else if(mp.containsValue(ch2)) return false;

            mp.put(ch1, ch2);
        }

        return true;
    }
    static boolean thirdApproach(String str1, String str2) {
        Map<Character, Character> mp = new HashMap<>();
        HashSet<Character> mp2 = new HashSet<>();

        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(mp.containsKey(ch1)){
                if(mp.get(ch1) != ch2) return false;
            }
            else if(mp2.contains(ch2)) return false;

            mp.put(ch1, ch2);
            mp2.add(ch2);
        }

        return true;
    }
}
