package RecursionQuetions.RecursionQuestions;

public class KeyboardCombination {
    public static String[] keypad = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void keyboarCombi(String str, int idx, String newStr) {

        if (idx == str.length()) {
            System.out.print(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            keyboarCombi(str, idx + 1, newStr + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "3";
        keyboarCombi(str, 0, "");
    }
}
