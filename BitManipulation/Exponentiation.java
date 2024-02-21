public class Exponentiation {
    public static int fastExpo(int n, int p) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * p;
            }
            p = p * p;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExpo(5, 3));
    }
}
