package RecursionQuetions.RecursionQuestions;

public class MoveXToEnd {
    public static void MoveX(String str, int idx, int count, StringBuilder newString) {

        // NEWSTRING (STORE ALL X AND MOVE TO END)

        // IDX TO TRACK EVERY CHARACTER
        // base case
        if (idx == str.length()) {
            // TO STORE ALL THOSE X IN NEW STRING WE CREATE FOR LOOP
            for (int i = 0; i < count; i++) {
                newString.append('x');
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        if (currChar == 'x') {
            // COUNT TO TRACk NUMBER OF X
            count++;
            MoveX(str, idx + 1, count, newString);
        } else {
            newString.append(currChar);
            MoveX(str, idx + 1, count, newString);
        }

    }

    public static void main(String[] args) {
        String str = "axbcxxd";
        MoveX(str, 0, 0, new StringBuilder(""));
    }
}
