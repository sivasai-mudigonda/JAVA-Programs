package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author u230107
 *
 *         LeetCode Ques - 202 {Happy Number}
 *         https://leetcode.com/problems/happy-number/
 *
 *         Write an algorithm to determine if a number is “happy”. A happy
 *         number is a number defined by the following process: Starting with
 *         any positive integer, replace the number by the sum of the squares of
 *         its digits, and repeat the process until the number equals 1 (where
 *         it will stay), or it loops endlessly in a cycle which does not
 *         include 1. Those numbers for which this process ends in 1 are happy
 *         numbers.
 *
 *         Example: Input: 19 Output: true Explanation: 1^2 + 9^2 = 82 8^2 + 2^2
 *         = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 *
 *         Solution-1: 
 *         1.> Find sum of squares of current number, add it to the
 *         SET 
 *         2.> The SET will keep track of sum of squares encountered 
 *         3.> Continue the process until a value repeats or if we find 1
 *
 *         Space Complexity for solution 1 : O(k) {for maintaining
 *         "digit_Square_Sum" in the hash set}
 *
 *         Solution-2: Using Floyd's and Hare Cycle Detection Algorithm {2
 *         pointer approach}
 *
 *         Space Complexity for solution 2 : O(1)
 *
 *         Time Complexity for solution-1 & solution-2 : if we assume the while
 *         loop executes k times, the time complexity will be O(kd)/O(kd*logk),
 *         if d denotes to the counts of digits of n in average/worst cases of
 *         search and insertion operations of hash sets
 *
 */
public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
		int num = 19;
		System.out.println("Is Happy Number = " + obj.isHappy(num)); // Expected Output = true
		System.out.println("Is Happy Number = " + obj.isHappy_Approach_2(num)); // Expected Output = true

		num = 2;
		System.out.println("Is Happy Number = " + obj.isHappy(num)); // Expected Output = false
		System.out.println("Is Happy Number = " + obj.isHappy_Approach_2(num)); // Expected Output = false
	}

	public boolean isHappy(int n) {
		if (n == 1) {
			return true;
		} else if (n == 0) {
			return false;
		}

		int digit_Square_Sum = n;
		Set<Integer> set = new HashSet<>();
		set.add(n);
		while (digit_Square_Sum != 1) {
			digit_Square_Sum = happyHelper(digit_Square_Sum);
			if (set.contains(digit_Square_Sum)) {
				return false; // Cycle Detected
			} else {
				set.add(digit_Square_Sum);
			}
		}
		return digit_Square_Sum == 1;
	}

	/**
	 *
	 * @param n
	 * @return
	 */
	private int happyHelper(int n) {
		int sum = 0;
		while (n > 0) {
			int dividend = n % 10;
			sum += dividend * dividend;
			n = n / 10;
		}
		return sum;
	}

	/**
	 *
	 * @param n
	 * @return Using Floyd's and Hare Cycle Detection Algorithm {2 pointer approach}
	 *         Refer "https://en.wikipedia.org/wiki/Cycle_detection" and
	 *         "https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare"
	 *         to understand more on algorithm
	 */
	public boolean isHappy_Approach_2(int n) {
		if (n == 1) {
			return true;
		} else if (n == 0) {
			return false;
		}
		int slow = n;
		int fast = n;
		do {
			slow = happyHelper(slow);
			fast = happyHelper(fast);
			fast = happyHelper(fast);
			if (slow == 1 || fast == 1) {
				return true;
			}
			// System.out.println(slow);
			// System.out.println(fast);
		} while (slow != fast);
		return slow == 1;
	}
}
