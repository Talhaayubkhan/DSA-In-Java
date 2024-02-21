package RecursionQuetions;

public class DecendingOrder {
    public static void decendingOrder(int n) {

        if (n == 1) {
            System.out.print(n);
            return;
        }

        System.out.println(n + " ");
        decendingOrder(n - 1);

    }

    public static void main(String[] args) {
        int n = 10;
        decendingOrder(n);
    }
}
