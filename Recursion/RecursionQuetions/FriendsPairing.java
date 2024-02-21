package RecursionQuetions;

public class FriendsPairing {
    public static int friendsPair(int n) {

        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        // // choices
        // // for single person
        // int fnm1 = firendsPair(n - 1);

        // // pair
        // int fnm2 = firendsPair(n - 2);
        // int pariWays = (n - 1) * fnm2;

        // int totalWays = fnm1 + pariWays;
        // return totalWays;

        return friendsPair(n - 1) + (n - 1) * friendsPair(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(friendsPair(3));
    }
}
