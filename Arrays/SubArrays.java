public class SubArrays {
    public static void subArr(int arr[]) {
        // Using Brute Force
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max Sum is is " + maxSum);
    }

    public static void subArrPrefixApproach(int arr[]) {
        // optimal than brute force
        int sum = 0;

        int maxSum = Integer.MIN_VALUE;
        int preFix[] = new int[arr.length];

        // calculate prefix arry
        preFix[0] = arr[0];
        for (int i = 1; i < preFix.length; i++) {
            preFix[i] = preFix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                sum = i == 0 ? preFix[j] : preFix[j] - preFix[i - 1];

                if (maxSum < sum) {
                    maxSum = sum;
                }
            }

        }
        System.out.println("Total SubArray Sum is " + maxSum);
    }

    public static void KadaneMaxSub(int arr[]) {

        // optimal than prefix
        int sum = 0;
        int MaxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            sum += arr[i];

            if (sum > MaxSum) {
                MaxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("MAX Sub Array is " + MaxSum);
    }

    public static void main(String[] args) {
        int arr[] = { -1, -2, -3, -4 };
        // subArr(arr);
        subArrPrefixApproach(arr);
    }
}
