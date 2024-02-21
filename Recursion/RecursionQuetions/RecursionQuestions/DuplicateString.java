package RecursionQuetions.RecursionQuestions;

public class DuplicateString {
    public static void removeDuplicateStr(String str, int idx, StringBuilder newString, boolean map[]) {

        if (idx == str.length()) {
            System.out.print(newString);
            return;
        }
        char currchar = str.charAt(idx);

        if (map[currchar - 'a'] == true) {
            removeDuplicateStr(str, idx + 1, newString, map);
        } else {
            map[currchar - 'a'] = true;
            removeDuplicateStr(str, idx + 1, newString.append(currchar), map);
        }
    }

    public static void main(String[] args) {
        String str = "ayubayewascyew";
        // removeDuplicateStr(str, 0, new StringBuilder(), new boolean[26]);
        removeDuplicateStr(str, 0, new StringBuilder(), new boolean[26]);
    }
}
