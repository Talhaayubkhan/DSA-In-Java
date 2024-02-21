public class TrapingRainWater {
    public static int trapWater(int arr[]) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        // we created two auxiliary Arrays (Helper Array)
        // create left and find maximum
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        // create right and find maximum
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        // merge both left and right and find minimum
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (Math.min(left[i], right[i]) - arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trapWater(arr));
    }
}
