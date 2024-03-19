package Problems_On_Hashmaps;

import java.util.*;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("we");
        s.add("say");
        s.add("#");
        s.add("2#yes");
        System.out.println(s);

        String str = encode(s);

        System.out.println(decode(str));
    }

    // TC: O(N)     SC: O(1)
    static public String encode(List<String> strs) {
        String str = "";

        for (String s : strs) {
            str += (s.length() + "#" + s);
        }

        return str;
    }

    // TC: O(N)     SC: O(1)
    static public List<String> decode(String str) {
        int i = 0;
        List<String> list = new ArrayList<>();

        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));

            int strStartIndex = j + 1;

            String string = str.substring(strStartIndex, strStartIndex+length);
            list.add(string);

            i = strStartIndex + length;
        }

        return list;
    }
}
