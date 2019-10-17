package Interviews;

class Veeva {
	public static void main(String str[]) {
		int[] arr = { 5, 2,1, 8};
		System.out.println(calStockHighestProfit(arr));
	}

	
	private static int calStockHighestProfit(int[] arr) {
		int highestProfit = 0;
		if(arr==null || arr.length==0) {
			return highestProfit;
		}
		int leastBuy = arr[0]; // best buy price
		// Time Complexity = O(N)
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1] && arr[i] < leastBuy) {
				leastBuy = arr[i];
			}

			if ((arr[i] - leastBuy) > highestProfit) {
				highestProfit = (arr[i] - leastBuy);
			}
		}

		// Time Complexity= O(n^2)
		/*for (int i = 0; i <(arr.length-1); i++) { // Current
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[j] - arr[i]) > highestProfit) {
					highestProfit = (arr[j] - arr[i]);
				}
			}
		}*/
		return highestProfit;
	}
}