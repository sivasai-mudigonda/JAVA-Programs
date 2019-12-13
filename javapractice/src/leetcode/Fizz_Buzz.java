package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @author u230107
*
* Leet-code Ques - 412 {Fizz Buzz} {Easy}
* https://leetcode.com/problems/fizz-buzz/
*
* Write a program that outputs the string representation of numbers from 1 to n.
* But for multiples of three it should output “Fizz” instead of the number
* and for the multiples of five output “Buzz”.
* For numbers which are multiples of both three and five output “FizzBuzz”.
*
	Example:
	n = 15,
	Return:
	[
	"1",
	"2",
	"Fizz",
	"4",
	"Buzz",
	"Fizz",
	"7",
	"8",
	"Fizz",
	"Buzz",
	"11",
	"Fizz",
	"13",
	"14",
	"FizzBuzz"
	]
*
*
* Time Complexity = O(N) - Loop for N elements
* Space complexity = o(1) - Constant Space
*
*/
public class Fizz_Buzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 15;
		Fizz_Buzz obj = new Fizz_Buzz();
		System.out.println("String Representation of numbers 1 to n = " + obj.fizzBuzz(n));
		System.out.println("String Representation of numbers 1 to n = " + obj.fizzBuzz_NoMod(n));
		// Expected Output = "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"
	}

	/**
	 *
	 * @param n
	 * @return
	 *
	 * Using Modulus Operator
	 *
	 */
	public List<String> fizzBuzz(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		List<String> resultLi = new ArrayList<>();
		int index = 1;
		while (index <= n) {
			if (index % 15 == 0) {
				resultLi.add("FizzBuzz");
			} else if (index % 3 == 0) {
				resultLi.add("Fizz");
			} else if (index % 5 == 0) {
				resultLi.add("Buzz");
			} else {
				resultLi.add("" + index);
			}
			index++;
		}
		return resultLi;
	}

	/**
	 *
	 * @param n
	 * @return
	 *
	 * Without Using Modulus Operator
	 *
	 */
	public List<String> fizzBuzz_NoMod(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		List<String> resultLi = new ArrayList<>();
		int fizz = 0;
		int buzz = 0;
		int index = 1;
		while (index <= n) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				resultLi.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			} else if (fizz == 3) {
				resultLi.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				resultLi.add("Buzz");
				buzz = 0;
				;
			} else {
				resultLi.add(String.valueOf(index));
			}
			index++;
		}
		return resultLi;
		
		/**
		 * Another solution using AbstractList
			 * return new java.util.AbstractList<String>() {
	            @Override
	            public int size() {
	                return n;
	            }
	                
	            @Override
	            public String get(int index) {
	                int i = index + 1;
	                
	                if(i % 3 == 0 && i % 5 == 0) {
	                    return "FizzBuzz";
	                }else if(i % 3 == 0) {
	                    return "Fizz";
	                }else if(i % 5 == 0) {
	                    return "Buzz";
	                }else{
	                    return String.valueOf(i);
	                }
	            }     
        	}; 
		 */
	}
}