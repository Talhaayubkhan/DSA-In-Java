package RecursionQuetions;

public class SumNaturalNum {
    public static int sumOfNaturalNum(int n) {

        if (n == 1) {
            return 1;
        }

        int SumNm1 = sumOfNaturalNum(n - 1);
        int sum = n + SumNm1;
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of Natural Num is: " + sumOfNaturalNum(n));
    }
}
