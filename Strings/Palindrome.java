public class Palindrome {
    public static boolean isPalindrome(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true; // All characters match, so the string is a palindrome. }
    }

    public static void main(String[] args) {
        String str = "madam";

        System.out.println(isPalindrome(str));
    }
}
