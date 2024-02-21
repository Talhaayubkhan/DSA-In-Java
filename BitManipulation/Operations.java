public class Operations {
    public static int getithBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setithBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearithBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateithBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        // return clearithBit(n, newBit);
        // } else {
        // return setithBit(n, newBit);
        // }

        n = clearithBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastIBit(int n, int i) {
        int bitMask = ~(0) << i;
        return n & bitMask;
    }

    public static int clearBitsInRange(int n, int i, int j) {
        int a = ~(0) << (j + 1);
        int b = (1 << i) - 1;
        int bitMask = (a | b);
        return n & bitMask;
    }

    public static boolean powerOf(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        // System.out.println(getithBit(10, 3));
        // System.out.println(setithBit(10, 2));
        // System.out.println(clearithBit(10, 1));
        // System.out.println(updateithBit(10, 2, 1));
        // System.out.println(clearLastIBit(15, 2));
        // System.out.println(clearBitsInRange(10, 2, 4));
        System.out.println(powerOf(16));
    }
}
