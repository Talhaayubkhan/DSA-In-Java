package RecursionQuetions;

public class BinaryString {
    public static void printbinaryString(int n, int lastPlace, String str) {

        if (n == 0) {
            System.out.println(str);
            return;
        }

        printbinaryString(n - 1, 0, str + '0');

        if (lastPlace == 0) {
            printbinaryString(n - 1, 1, str += "1");
        }

    }

    public static void printBinaryStr(int n, int lastPlace, String str) {

        // base case

        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinaryStr(n - 1, 1, str + "1");

        if (lastPlace == 1) {
            printBinaryStr(n - 1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        // printbinaryString(3, 0, "");
        printBinaryStr(3, 1, "");
    }
}
