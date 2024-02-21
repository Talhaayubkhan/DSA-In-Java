package Questions;

import java.util.*;

import java.lang.reflect.Array;

public class Anagrams {
    public static boolean checkAnagrams(String str1, String str2) {

        // case 1 : everey char Sort
        if (str1.length() != str2.length())
            return false;
        str1 = sortString(str1);
        str2 = sortString(str2);

        // check lenght if we equal so this is anagrms
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String sortString(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public static void main(String[] args) {
        String str1 = "CAT";
        String str2 = "ARCT";
        System.out.println(checkAnagrams(str1, str2));
    }
}
