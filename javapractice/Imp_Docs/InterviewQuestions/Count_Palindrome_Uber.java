package javapractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author SivaM
 *
 * Count no of Palindromes in a String
 * -> Palindrome Length should be equal to String length
 * -> Get only Unique Palindrome Count
 * -> Use all characters of a String
 *
 */
public class Count_Palindrome_Uber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count_Palindrome_Uber obj = new Count_Palindrome_Uber();
		
		String s1 = "MADAM";
		System.out.println("Palindome Count = " +obj.palindromeCnt(s1)); // Expected Output = 2
		
		String s2= "ARWtaaSwtIasI"; // Was It A Rat I Saw
		System.out.println("Palindome Count = " +obj.palindromeCnt(s2.toLowerCase())); // Expected Output = 360
		
		String s3 = "malayalam";
		System.out.println("Palindome Count = " +obj.palindromeCnt(s3.toLowerCase())); // Expected Output = 12
	}
	
	public int palindromeCnt(String s ){
		if(s==null || s.length()==0 ){
			return 0;
		}
		Map<Character, Integer> strCntMap = new HashMap<>();
		for(char c: s.toCharArray() ){
			strCntMap.compute(c,(k,v)->{
				return v==null?1:v+1;
			});
		}
		boolean allowOneChar = false;
		boolean canFormPalindrome = true;
		int div=1;
		for(int n: strCntMap.values() ){
			if(n%2==0 ){
				if(n > 2 ){
					div*=calFact(n/2);
				}
				continue;
			}
			// Allow one odd char
			if(allowOneChar ){
				canFormPalindrome = false;
				break;
			} else{
				allowOneChar = true;
			}
		}
		int result=0;
		/*
		 * eg: "malayalam" Length = 9
		 * 9 is odd, So, (9-1)/2 = 8/2 = 4
		 * factPal = calFact(4)=24
		 * 
		 * Char Cnt:
		 * M-2 => 2/2 = 1= calFact(1)=1 
		 * A-4 => 4/2 = 2= calFact(2)=2
		 * L-2 => 2/2 = 1= calFact(1)=1
		 * Y-1 => 2/2 = 1= calFact(1)=1
		 * div = 1*2*1*1 =2
		 * 
		 * result = factPal/div = 24/2 = 12
		 * 
		 */
		if(canFormPalindrome ) {
			int factPal=0;
			if(s.length()%2==0) {
				factPal = s.length()/2;
			} else {
				factPal = (s.length()-1)/2;
			}
			result = calFact(factPal);
			if(div > 0 ){
				result/=div;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 * 
	 * Calculate Factorial
	 * 
	 */
	private int calFact(int n) {
		if(n==1) {
			return n;
		}
		return n*calFact(n-1);
	}
}
