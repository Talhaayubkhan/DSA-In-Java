package RecursionQuetions.RecursionQuestions;

public class TowerofHonai {
    public static void towerofhonai(int n, String source, String helper, String destination) {
        // base case
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
            return;
        }

        towerofhonai(n - 1, source, destination, helper);
        System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
        towerofhonai(n - 1, helper, source, destination);

    }

    public static void main(String[] args) {
        int n = 3;
        towerofhonai(n, "A", "B", "C");
    }
}
