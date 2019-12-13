package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
* @author u230107
*
* Leet-code - 454 {4Sum II} {Medium}
* https://leetcode.com/problems/4sum-ii/
*
* Given four lists A, B, C, D of integer values,
* compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
*
* To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
* All integers are in the range of -2^28 to 2^28–1 and the result is guaranteed to be at most 2^31–1.
*
	Example:
	Input:
	A = [ 1, 2]
	B = [-2,-1]
	C = [-1, 2]
	D = [ 0, 2]
	
	Output:
	2
	
	Explanation:
	The two tuples are:
	1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
	2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*
* Solution:
* Use a hash map to save sum of all pairs of first two lists.
* And then iterate all pairs of other two lists to find its negative one.
* {Reduce the 4D problem to two 2D problem}
*
* Time Complexity = O(N^2) - Loop through A+B or C+D Arrays.
* Space Complexity = O(N^2) - Store sum of all A and B array elements in HashMap.
*
*/
public class FourSum_Two {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FourSum_Two obj = new FourSum_Two();
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		System.out.println("Number of Tuples whose sum is zero = " + obj.fourSumCount(A, B, C, D)); // Expected Result =
																									// 2
	}

	/**
	 *
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> sum_Cnt_AB = new HashMap<>();
		for (int a : A) {
			for (int b : B) {
				// Sum A+B(Key} and count{Freq of Sum} as its value.
				sum_Cnt_AB.put(a + b, sum_Cnt_AB.getOrDefault(a + b, 0) + 1);
			}
		}
		int counter = 0;
		for (int c : C) {
			for (int d : D) {
				// we need to find 0-sum from map so that result is zero
				counter += sum_Cnt_AB.getOrDefault(-(c + d), 0);
			}
		}
		return counter;
	}
}