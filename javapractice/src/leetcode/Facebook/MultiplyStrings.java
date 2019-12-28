/**
 * 
 */
package leetcode.Facebook;

/**
 * @author SivaM
 *
 * Leet-code Ques - 43 {Multiply Strings} {Medium}
 * https://leetcode.com/problems/multiply-strings/
 *
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2, also represented as a string.
 * 
	Example 1:
	Input: num1 = "2", num2 = "3"
	Output: "6"
	
	Example 2:
	Input: num1 = "123", num2 = "456"
	Output: "56088"
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Time Complexity = O(M+N) - To compute product of each character of num1 String with each character of num2 String.
 * Space Complexity = o(M+N) - Space required to store elements in vals array.
 *
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiplyStrings obj = new MultiplyStrings();
		
		String num1="2";
		String num2="3";
		System.out.println("Product = "+obj.multiply(num1, num2)); // Expected Output = 6
		
		System.out.println("*******************************");
		
		num1="123";
		num2="456";
		System.out.println("Product = "+obj.multiply(num1, num2));  // Expected Output = 56088
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * 
	 * Store carry{quotient} in i+j index of vals array. In the next iteration, we shall add it to product.
	 * Store actual-value{reminder} in i+j+1 index of vals array.
	 * 
	 */
	public String multiply(String num1, String num2) {
		if(num1=="0" && num2=="0" ){
			return "0";
		}
		int[] vals = new int[num1.length()+num2.length()];
		StringBuilder sb = new StringBuilder();
		for(int i=num1.length()-1;i>=0;i--) {
			for(int j=num2.length()-1;j>=0;j--) {
				int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				int sumProductCarry = vals[i+j+1] + product;
				int actualNumIndex = i+j+1;
				int carryIndex = i+j;
				vals[carryIndex]+= sumProductCarry/10;
				vals[actualNumIndex] = sumProductCarry%10;
			}
		}
		for(int v : vals) {
			// To avoid leading zero.
			if(!(sb.length()==0 && v==0)  ){
			    sb.append(v);
			}
		}
		return sb.length()==0?"0":sb.toString();
	}
}