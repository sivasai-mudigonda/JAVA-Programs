/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *         Leet Code 166. Fraction to Recurring Decimal
 *
 *         Given two integers representing the numerator and denominator of a fraction, return the fraction in string format. If the fractional
 *         part is repeating, enclose the repeating part in parentheses.
 *
 *         XOR (^) = Binary XOR Operator copies the bit if it is set in one operand but not both. 
 *         eg: (0011 1100 ^ 0000 1101) will give 49 which is 0011 0001
 *
 *         Time Complexity = O(1) 
 *         Space Complexity =o(n), where n represents elements stored in hashmap.
 *         
 *         Refer https://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
 *         
 */
public class FractionToRecurringDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numerator = 1;
		int denominator = 2;
		String res = fractionToDecimal(numerator, denominator);
		System.out.println("Decimal Format = " + res); // Expected Output = "0.5"

		numerator = 2;
		denominator = 1;
		res = fractionToDecimal(numerator, denominator);
		System.out.println("Decimal Format = " + res); // Expected output = "2"

		numerator = 2;
		denominator = 3;
		res = fractionToDecimal(numerator, denominator);
		System.out.println("Decimal Format = " + res); // Expected output = "0.(6)"
	}
	
	private static String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0) {
			return "0";
		}
		
		if(denominator==0) {
			return ""; // Infinite 
		}
		
		StringBuilder sb = new StringBuilder();
		// Handle -ve
		if( (numerator < 0) ^ (denominator < 0) ){
			sb.append("-");
		}
		
		long nume = numerator;
		long dene = denominator;
		
		nume = Math.abs(nume);
		dene = Math.abs(dene);
		
		long quotient =  nume /dene;
		long reminder = nume % dene *10;
		sb.append(quotient);
		if(reminder  == 0) {			
			return sb.toString();
		}
		
		sb.append(".");
		List<Long> li = new ArrayList<>();
		while(reminder!=0) {
			quotient = reminder / dene;
			if(li.contains(quotient) ){
				sb.replace(sb.length()-1, sb.length(), "("+quotient+")");
				 return sb.toString();
			}
			sb.append(quotient);
			li.add(quotient);
			reminder = reminder % dene *10;
		}
		return sb.toString();
	}
}
