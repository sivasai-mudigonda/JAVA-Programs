package interviews;

public class MaxProfitStock_SalesForce {

	public static void main(String[] str) {
		int[] arr1 = { 2, 4, 5, 6 };
		maxProfit(arr1);

		int arr2[] = { 2, 4, 1, 7, 8, 10 };
		calMaxProfit(arr2);
	}

	// Refer https://www.youtube.com/watch?v=76-CYD0jn7s
	// Time Complexity is O(n)
	private static void maxProfit(int arr[]) {
		if (arr == null || arr.length == 0) {
			System.out.println("No stock data found");
		}
		int profit = 0;
		int min_buy_price = arr[0];
		for (int i = 0; i < arr.length; i++) {
			profit = Math.max(profit, arr[i] - min_buy_price);
			min_buy_price = Math.max(arr[i], min_buy_price);
		}
		System.out.println(profit);
	}

	/** Refer
	  * https://www.youtube.com/watch?v=vxIMqdR8flY&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-&t=0s&index=42
	  * Time Complexity is O(n)
	  *   
	  * Note: You may complete as many transactions as you like multiple times.
	*/
	private static void calMaxProfit(int arr[]) {
		int maxProfit = 0;
		if (arr.length <= 1) {
			System.out.println(maxProfit);
			System.exit(0);
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				maxProfit += arr[i] - arr[i - 1];
			}
		}
		System.out.println(maxProfit);
	}
}