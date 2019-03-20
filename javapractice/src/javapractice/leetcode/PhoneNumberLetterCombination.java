package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent?
 * http://www.goodtecher.com/leetcode-17-letter-combinations-of-a-phone-number/
 * 
 * https://www.youtube.com/watch?v=h6FmiyYDjmk&index=16&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-
 * 
 * 
 * Time Complexity = O(V+E)
 */
public class PhoneNumberLetterCombination {
	
	public static void main(String s[]) {
		List<String> resultLi=letterCombinations("23");
		System.out.println(resultLi.toString()); // Expected Output ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	}
    
	private static List<String> letterCombinations(String digits){
		List<String> result= new ArrayList<>();
		if(digits==null || digits.isEmpty() || digits.equals("0") || digits.equals("1") || digits.equals("01") || digits.equals("10")) {
			return result;
		}
		Map<Character,char[]> map = buildPhoneMap();
		StringBuilder sb = new StringBuilder();
		getCombinations(sb,map,digits,result);
		return result;
	}
	
	private static Map<Character,char[]> buildPhoneMap(){
		Map<Character,char[]> map= new HashMap<>();
		map.put('2',new char[]{'a','b','c'});
		map.put('3',new char[]{'d','e','f'});
		map.put('4',new char[]{'g','h','i'});
		map.put('5',new char[]{'j','k','l'});
		map.put('6',new char[]{'m','n','o'});
		map.put('7',new char[]{'p', 'q', 'r', 's'});
		map.put('8',new char[]{'t','u','v'});
		map.put('9',new char[]{'w', 'x', 'y', 'z'});
		return map;
	}
	
	private static void getCombinations(StringBuilder sb, Map<Character,char[]> map, String digits, List<String> result) {
		if(digits.length()==sb.length() ){
			result.add(sb.toString());
			return;
		}
		for(char c:map.get(digits.charAt(sb.length())) ){
			sb.append(c);
			getCombinations(sb,map,digits,result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
