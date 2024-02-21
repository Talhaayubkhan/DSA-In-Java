package RecursionQuetions.RecursionQuestions;

import java.util.HashSet;

public class Stringsubsequences {
    public static void subSequences(String str, int idx, String newStr, HashSet<String> set) {

        // base case

        if (idx == str.length()) {
            if (set.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }

        char currChar = str.charAt(idx);
        // to be
        subSequences(str, idx + 1, newStr + currChar, set);
        subSequences(str, idx + 1, newStr, set);
        // or not to be

    }

    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        subSequences(str, 0, "", set);
    }
}
