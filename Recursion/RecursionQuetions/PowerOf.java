package RecursionQuetions;

public class PowerOf {
    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        // int xnm1 = power(x, n - 1);
        // int xn = x * xnm1;
        // return xn;
        return x * power(x, n - 1);
    }

    // Optimized O(Logn)
    public static int OptimizePowerofN(int x, int n) {

        // base case
        if (n == 0) {
            return 1;
        }
        int half = OptimizePowerofN(x, n / 2);
        int halfSq = half * half;

        // if num is odd

        if (n % 2 != 0) {
            halfSq = x * halfSq;
        }
        return halfSq;
    }

    public static void main(String[] args) {
        // System.out.println(power(2, 10));
        System.out.println(OptimizePowerofN(2, 10));
    }
}
