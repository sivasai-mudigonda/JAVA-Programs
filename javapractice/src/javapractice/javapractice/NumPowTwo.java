/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */
public class NumPowTwo {

	/**
	 * @param args
	 */
	
	// 2^X=num. Find Y.
	// X= log num to the base 2. i.e., log num /log 2.
	public static void main(String[] args) {
		int num=16;
		boolean isNumPow=isNumPow(num);
		System.out.println("isNumPowTwo = " +isNumPow);
		
	}
	
	private static boolean isNumPow(int num) {
		//round up and check
		if (Math.ceil(Math.log(num) / Math.log(2) ) ==
				Math.floor(Math.log(num) / Math.log(2) )  ){
			return true;
		}
		return false;
	}

}
