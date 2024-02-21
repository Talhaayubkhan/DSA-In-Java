package RecursionQuetions;

public class RemoveDuplicatString {

    // public static String removeduplicateString(String str) {
    // // brute force Method
    // // create new string to store original string
    // String ans = " ";

    // for (int i = 0; i < str.length(); i++) {
    // int j = 0;
    // for (j = 0; j < i; j++) {
    // // if same char found
    // if (str.charAt(i) == str.charAt(j)) {
    // break;
    // }
    // }
    // if (i == j) {
    // ans += str.charAt(i);
    // }
    // }
    // return ans;
    // }

    public static void removeDuplicateInOptimizedWay(String str, int idx, StringBuilder newStr, boolean map[]) {

        // base case for
        if (idx == str.length()) {
            System.out.print(newStr);
            return;
        }

        // what we can do actually
        // put current char in current position
        char currChar = str.charAt(idx);

        if (map[currChar - 'a'] == true) {
            // duplicate present
            removeDuplicateInOptimizedWay(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicateInOptimizedWay(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "aayyub";
        System.out.println("Before Duplication " + str);
        // System.out.println("After Duplication " + removeduplicateString(str));
        removeDuplicateInOptimizedWay(str, 0, new StringBuilder(), new boolean[26]);
    }
}
