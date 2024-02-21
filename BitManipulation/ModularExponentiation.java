public class ModularExponentiation {

    public static int moduleExpo(int x, int y, int p) {
        int ans = 1;

        while (y > 0) {
            if ((y & 1) != 0) {
                ans = ans * x;
            }

            x = x * x;
            y = y >> 1;
        }
        return ans % p;
    }

    public static void main(String[] args) {
        System.out.println(moduleExpo(2, 3, 5));
    }
}
