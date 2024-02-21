import java.util.*;

public class UnionArrays {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        HashSet<Integer> s = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            s.add(arr2[i]);
        }

        for (int it : s) {
            result.add(it);
        }
        return result;
    }

    public static ArrayList<Integer> unionOFIntegers(int arr1[], int arr2[], int n, int m) {

        ArrayList<Integer> Union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                // before we compare if element are equal in same array, avoid duplicates we
                // create another if statement
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i]) {
                    Union.add(arr1[i]);
                }
                i++;
            } else {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j]) 
                    Union.add(arr2[j]);
                j++;
            }
        }

        // if some elements are remaining in both of the arrays(Arr1, Arr2) in some condition
        while (i < n) {
            if (Union.get(Union.size() - 1) != arr1[i]) {
                Union.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (Union.get(Union.size() - 1) != arr2[j]) {
                Union.add(arr2[j]);
            }
            j++;
        }

        return Union;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int arr1[] = { 1, 1, 3, 4, 5 };
        int arr2[] = { 2, 3, 3, 4, 5, 6 };
        // ArrayList<Integer> result = findUnion(arr1, arr2, n, m);
        // System.out.print("result of Two Union Array or = ");
        // for (int val : result) {
        // System.out.print(val + " ");
        // }

        ArrayList<Integer> Union = unionOFIntegers(arr1, arr2, n, m);
        System.out.println("Result of Two Union Array is =");

        for (int val: Union) {
            System.out.print(val + " ");
        }

    }
}
