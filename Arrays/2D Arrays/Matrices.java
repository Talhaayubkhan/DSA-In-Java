import java.util.*;

public class Matrices {

    public static boolean search(int matrix[][], int maxValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxValue = Integer.MIN_VALUE;
                // int minValue = Integer.MIN_VALUE;
                if (matrix[i][j] == maxValue) {
                    maxValue = Math.max(maxValue, matrix[i][j]);
                    System.out.print("Maximum can found at " + maxValue);
                    return true;
                }
            }
        }
        System.out.print("Found!");
        return true;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length;
        int m = matrix[0].length;

        // input
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix, m);
    }

}
