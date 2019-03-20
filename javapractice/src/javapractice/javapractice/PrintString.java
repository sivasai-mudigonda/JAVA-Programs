/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */

/*
 * Print the string after the specified character has occurred given no. of times
 */
public class PrintString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str=" geeksForgeeks";
		char c='g';
		int count=2;
		printString(str,c,count);
	}
	
	private static void printString(String str, char c, int count) {
		if(count==0) {
			System.out.println("String is empty");
		}
		int counter=0,i=0;
		while(i<str.length() ){
			if(str.charAt(i)==c) {
				counter++;
			}
			if(counter==count) {
				break;
			}
			i++;
		}
		
		if(i<str.length()) {
			System.out.println("Remaining String = "+str.substring(i+1));
		} else {
			System.out.println("Remaining string is empty");
		}
	}

}
