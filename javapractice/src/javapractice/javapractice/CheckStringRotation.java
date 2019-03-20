/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */

// Given two strings, 
// the task is to find if a string can be obtained by rotating another string two places?
public class CheckStringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(checkStringRotation("eksge","geeks"));
		System.out.println(checkStringRotation("eksge","geeks"));
	}
	
	private static boolean checkStringRotation(String rotatedString, String target) {
		if(rotatedString==null || target==null || rotatedString.isEmpty() 
				|| target.isEmpty() || rotatedString.length()==target.length() || rotatedString.length()>2 || target.length()>2) {
			return false;
		}
		// second to last characters +first 2 characters
		String clockWise= rotatedString.substring(2)+rotatedString.substring(0, 2);   
		// last 2 char+ first to (last-2) characters
		String antiClockWise = rotatedString.substring(rotatedString.length()-2, rotatedString.length()) + rotatedString.substring(0,rotatedString.length()-2);
		if(clockWise.equalsIgnoreCase(target) || antiClockWise.equalsIgnoreCase(target) ){
			return true;
		}
		return false;
	}
}
