package RecursionQuetions.RecursionQuestions;

public class StringLength {
    public static int lengthofString(String str) {

        if (str.length() == 0) {
            return 0;
        }
        return lengthofString(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "hello World";
        System.out.println(lengthofString(str));
    }
}
