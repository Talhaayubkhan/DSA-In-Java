package RecursionQuetions;

public class Tilling {
    public static int tillingProb(int n) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // // for vertical
        // int fnm1 = tillingProb(n - 1);
        // // for horizontal
        // int fnm2 = tillingProb(n - 2);

        // int totalWays = fnm1 + fnm2;
        // return totalWays;

        return tillingProb(n - 1) + tillingProb(n - 2);

    }

    public static void main(String[] args) {
        System.out.print(tillingProb(4));
    }
}
