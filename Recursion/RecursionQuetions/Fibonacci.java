package RecursionQuetions;

public class Fibonacci {
    public static int calcFibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int fibnm1 = calcFibonacci(n - 1);
        int fibnm2 = calcFibonacci(n - 2);
        int fibn = fibnm1 + fibnm2;
        return fibn;

    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(calcFibonacci(n));
    }
}
