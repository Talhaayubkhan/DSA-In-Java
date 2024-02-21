package Questions;

public class Vowels {
    public static void vowelsOccurence(String str) {
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                    || ch == 'u') {
                count++;
            }
        }
        System.out.println("Vowels occurence are: " + count);
    }

    public static void main(String[] args) {
        String str = "abscdefgijkoxu";
        vowelsOccurence(str);
    }
}
