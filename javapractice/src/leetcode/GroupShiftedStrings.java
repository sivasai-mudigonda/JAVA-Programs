/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SivaM
 * 
 * 
 * Given a string, we can “shift” each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * 
	For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
	Return:
	[
	  ["abc","bcd","xyz"],
	  ["az","ba"],
	  ["acef"],
	  ["a","z"]
	]
 *
 * Note: For the return value, each inner list’s elements must follow the lexicographic order.
 * For Solution, refer
 * https://medium.com/leetcode-%E6%BC%94%E7%AE%97%E6%B3%95%E6%95%99%E5%AD%B8/017-leetcode-249%E6%BC%94%E7%AE%97%E6%B3%95-group-shifted-strings-%E7%BE%A4%E7%B5%84%E5%81%8F%E7%A7%BB%E5%AD%97%E4%B8%B2-c8fa3aeb5548
 * 
 * Time Complexity : O(N) - To iterate through strings array
 * Space Complexity : o(N) - To store key{offset} and value{group of strings with same offset}
 * 
 */
public class GroupShiftedStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroupShiftedStrings obj = new GroupShiftedStrings();
		String[] strArr = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println("Group Shifted Strings = "+obj.groupStrings(strArr));
		/*
		 * Expected Output:
		 * [
		 * 	  ["abc","bcd","xyz"],
		 *    ["az","ba"],
		 *    ["acef"],
		 *    ["a","z"]
		 * ]
		 */
	}
	
	/**
	 * 
	 * @param strings
	 * @return
	 * 
	 *  Lower case a-z ASCII value is 97-122
	 */
	public List<List<String>> groupStrings(String[] strings) {
		if(strings==null || strings.length==0) {
			return new ArrayList<List<String>>(); 
		}
		List<List<String>> resultLi =  new ArrayList<>();
		Map<String,List<String>> map = new HashMap<>();
		Arrays.stream(strings).forEach(string->{
			int offset = string.charAt(0) - 'a'; // Consider first chracter of string to calculate offset.
			StringBuilder sb = new StringBuilder();
			String key;
			string.chars().forEach(i->{      // mapToObj(c->(char)c).forEach - To convert ASCII to char
				char c = (char)(i - offset);
				if(c < 'a') {
					/*
					 * It should be noted that this part of az->ba, 
					 * which may be negative, 
					 * directly adds 26 (lower case) to let him offset.
					 */
					c+=26;
				}
				sb.append(c);
			});
			/*
			 * If you look at the input to infer, you can get abc->bcd, which are all three consecutive letters. 
			 * Next, use abc->xyz, you can infer that the question is to ask a-> b, b->x, c->z need to have the same offset length.
			 * key contains irst transformation of the current String {eg: xyz first transformation is abc}
			 */
			key = sb.toString(); 
			List<String> li =map.getOrDefault(key, new ArrayList<String>());
			li.add(string);
			map.put(key,li);
		});
		
		map.keySet().forEach(k->{
			List<String> li = map.get(k);
			li.sort(Comparator.naturalOrder()); // Refer https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
			resultLi.add(li);
		});
		return resultLi;
	}
}
