public class SellandBuy {
    public static int buyStockAndSell(int arr[]) {
        int n = arr.length; // Get the length of the array
        // Initialize the minimum price to the first element of the array
        int min = arr[0];
        // Initialize the maximum profit to 0
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // Calculate the potential profit if selling at the current price
            int cost = arr[i] - min;
            // Update maxProfit if the current cost is higher
            maxProfit = Math.max(maxProfit, cost);
            // Update min if the current price is lower than the previously recorded
            // minimum price
            min = Math.min(min, arr[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = buyStockAndSell(arr);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
