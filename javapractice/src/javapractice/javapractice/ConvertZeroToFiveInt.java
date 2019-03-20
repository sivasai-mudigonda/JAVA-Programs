/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */

/**
 * 
 * Given a integer as a input and replace all the ‘0’ with ‘5’ in the integer?
 * 
 * Examples:
    	102 - 152
    	1020 - 1525 
 * Note: Use of array to store all digits is not allowed. 
 *
 * Refer https://www.geeksforgeeks.org/replace-0-5-input-integer/
 */
public class ConvertZeroToFiveInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		util(50);
		util(102);
		util(1020);
		util(10120);
	}
	
	private static void util(int num) {
		System.out.println("Original number : "+num);
		System.out.print("After replacement, num is : ");
		if(num==0){ // To handle zero
			System.out.print("5");
		} else {
			System.out.print(convertZeroToFive(num));
		}
		System.out.println();
	}
	
	// Reminder gives ones digit. Quotient gives rest of the number.
	private static int convertZeroToFive(int num) {
		if(num==0) {
			return 0;
		}
		int onesDigit=num%10;
		if(onesDigit==0){
			onesDigit=5; // Replace with 0 with 5.
		}
		return convertZeroToFive(num/10)*10+onesDigit;
	}
}
