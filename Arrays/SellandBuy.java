public class SellandBuy {

    public static int Stock(int arr[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            // profit
            if (buyPrice < arr[i]) {
                // today profit
                int profit = arr[i] - buyPrice;
                // maximum profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = arr[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(Stock(arr));

    }
}
