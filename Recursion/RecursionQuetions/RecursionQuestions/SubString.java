package RecursionQuetions.RecursionQuestions;

public class SubString {
    public static int allsubString(String s, int start, int end, int n) {
        if (n == 1) {
            return n;
        }
        if (n <= 0) {
            return 0;
        }

        int res = allsubString(s, start + 1, end, n - 1) + allsubString(s, start, end - 1, n - 1)
                - allsubString(s, start + 1, end - 1, n - 2);
        if (s.charAt(start) == s.charAt(end)) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcab";
        int n = s.length();
        System.out.println(allsubString(s, 0, n - 1, n));
    }
}
