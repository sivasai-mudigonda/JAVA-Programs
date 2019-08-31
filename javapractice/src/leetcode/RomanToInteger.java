package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author u230107
 * 
 *         Leetcode-13 - Roman To Integer
 *         https://leetcode.com/problems/roman-to-integer/
 * 
 *         Given a roman numeral, convert it to an integer. Input is guaranteed
 *         to be within the range from 1 to 3999.
 * 
 *         Example : Input : "XIV" Return : 14 Input : "XX" Output : 20
 *
 *
 *         Time-Complexity = O(N) Space-Complexity = o(1)
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToIntegerUtil("XIV")); // Output= 14
		System.out.println(romanToIntegerUtil("XX")); // Output= 20
		System.out.println(romanToIntegerUtil("IX")); // Output = 9
		System.out.println(romanToIntegerUtil("XL")); // Output = 40
		System.out.println(romanToIntegerUtil("MCMIV")); // Output = 1904
	}

	private static int romanToIntegerUtil(String str) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int prev = 0;
		int res = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			int curr = map.get(str.charAt(i));
			if (curr < prev) {
				// eg:IV, IX
				res -= curr;
			} else {
				res += curr;
			}
			prev = curr;
		}
		return res;
	}
}
