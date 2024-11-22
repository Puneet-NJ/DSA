package Basic;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }

    static boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(isValidChar(s.charAt(left)) && isValidChar(s.charAt(right))) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            }

            if(!isValidChar(s.charAt(left))) {
                left++;
            }
            else if(!isValidChar(s.charAt(right))) {
                right--;
            }
        }

        return true;
    }

    static boolean isValidChar(char ch) {
        int ascii = ch;

        if(ascii > 47 && ascii < 58) {
            return true;
        }
        else if(ascii > 64 && ascii < 91) {
            return true;
        }
        else if(ascii > 96 && ascii < 123) {
            return true;
        }

        return false;
    }

    //TC: O(N)      SC: O(N) to store answer
    static public boolean isPalindrome(String s) {
        String s2 = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                s2 += Character.toLowerCase(ch);
            }
        }

        return s2.equals(rev(s2));
    }
    static String rev(String str) {
        StringBuffer str2 = new StringBuffer(str);

        str2.reverse();

        return str2.toString();
    }
}
