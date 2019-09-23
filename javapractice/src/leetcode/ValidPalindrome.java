/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 125 {Valid Palindrome}
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
	Example 1:
	
	Input: "A man, a plan, a canal: Panama"
	Output: true
	Example 2:
	
	Input: "race a car"
	Output: false
 *
 * Time Complexity = O(N)
 * Space Complexity = o(1)
 */
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPalindrome obj = new ValidPalindrome();
		String s1="A man, a plan, a canal: Panama";
		System.out.println("Is Valid Palidrome = " +obj.isPalindrome(s1)); // Expected Output = true
		
		String s2="race a car";
		System.out.println("Is Valid Palidrome = " +obj.isPalindrome(s2)); // Expected Output = false
	}
	
	private boolean isPalindrome(String s) {
		if(s==null || s.length()==0) {
			return true;
		}
		int start=0;
		int end=s.length()-1;
		while(start<end ){
			if(!isAlphaNumeric(s.charAt(start)) ){
				start++;
				continue;
			}
			
			if(!isAlphaNumeric(s.charAt(end)) ){
				end--;
				continue;
			}
			
			if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)) ){
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
    }
	
	private boolean isAlphaNumeric(char c) {
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') ){
			return true;
		}
		return false;
	}
}
