package practice;

import java.util.Arrays;

/**
 * @author u230107
 *
 *         Find minimum number of coins that make a given value? Given a value
 *         V, if we want to make change for V cents, and we have infinite supply
 *         of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum
 *         number of coins to make the change?
 * 
 * 
 *         Refer "https://www.youtube.com/watch?v=jgiZlGzXMBw"
 */
public class CoinChange {
	// Dynamic Programming
	private static int minCoins(int arr[], int length, int target) {
		if (arr == null || target == 0 || length == 0) {
			return 0;
		}
		int[] table = new int[target + 1]; // Considering sum as zero, so +1
		Arrays.fill(table, Integer.MAX_VALUE);
		table[0] = 0; // For sum zero, no coins required.

		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i >= arr[j]) { // coin is greater than target
					int sub_result = table[i - arr[j]];
					if (sub_result != Integer.MAX_VALUE && sub_result + 1 < table[i]) {
						table[i] = sub_result + 1;
					}
				}
			}
		}
		return table[target];
	}

	// Recursive Programming.
	/*
	 * The time complexity of above solution is exponential. If we draw the complete
	 * recursion tree, we can observer that many subproblems are solved again and
	 * again. Therefore it is inefficient.
	 */
	static int minCoinsRecurssive(int arr[], int length, int target) {
		if (target == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= target) {
				int sub_result = minCoinsRecurssive(arr, length, target - arr[i]);
				if (sub_result != Integer.MAX_VALUE && sub_result + 1 < result) {
					result = sub_result + 1;
				}
			}
		}
		return result;
	}

	// Driver Function to test above function
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		System.out.println(minCoins(arr, m, n));
		System.out.println(minCoinsRecurssive(arr, m, n));
	}
}