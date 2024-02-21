public class EvenOdd {
    public static void isEvenOdd(int n) {
        int bitMask = 1;

        if ((n & bitMask) != 0) {
            System.out.println("Odd Number ");
        } else {
            System.out.println("Even Number ");
        }

    }

    public static void main(String[] args) {
        isEvenOdd(13);
        isEvenOdd(10);
        isEvenOdd(14);
    }
}
