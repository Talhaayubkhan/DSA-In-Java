import java.util.*;

public class InterSection {

    public static ArrayList<Integer> intersectionNum(int a[], int b[]) {

        ArrayList<Integer> interSection = new ArrayList<>();

        int visited[] = new int[b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] && visited[j] == 0) {
                    interSection.add(a[i]);
                    visited[j] = 1;
                    break;

                }
                if (b[j] > a[i]) {
                    break;
                }
            }
        }

        return interSection;
    }

    public static ArrayList<Integer> optimalIntersection(int a[], int b[], int n, int m) {

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                ans.add(a[i]);
                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 7;
        int a[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int b[] = { 2, 3, 3, 5, 6, 6, 7 };

        // For Brute Force 
        // ArrayList<Integer> interSection = intersectionNum(a, b);

        // System.out.print("InterSection of Num is = ");

        // for(int val: interSection){
        // System.out.print(val + " ");
        // }

        // For Optimal 
        ArrayList<Integer> ans = optimalIntersection(a, b, n, m);

        System.out.print("InterSection of Num is = ");

        for(int val: ans){
            System.out.print(val + " ");
        }
    }
}
