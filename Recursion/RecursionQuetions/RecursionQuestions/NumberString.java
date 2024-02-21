package RecursionQuetions.RecursionQuestions;

public class NumberString {

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void stringConvert(int num) {
        if (num == 0) {
            return;
        }

        int lastDigit = num % 10;
        stringConvert(num / 10);
        System.out.print(digits[lastDigit] + " ");

    }

    public static void main(String[] args) {
        stringConvert(564);
    }
}
