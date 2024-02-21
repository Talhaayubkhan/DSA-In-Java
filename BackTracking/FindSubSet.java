public class FindSubSet {
    public static void findsubSets(String str, String ans, int i) {

        // base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // yes choice
        findsubSets(str, ans + str.charAt(i), i + 1);
        // no choice
        findsubSets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findsubSets(str, "", 0);
    }
}
