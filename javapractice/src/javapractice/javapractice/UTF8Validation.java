/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 *Given an array of integers representing the data, return whether it is a valid utf-8 encoding?
 *
 *A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

  For 1-byte character, the first bit is a 0, followed by its unicode code.
  For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * 
 * Refer https://www.youtube.com/watch?v=-r1cL8lCLeM
 */
public class UTF8Validation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.toBinaryString(130));
		//System.out.println(Integer.toBinaryString(192));
		//System.out.println(130 & 192);
		int arr[]= {197,130,1};
		System.out.println(utf8Validation(arr)); // Expected Result = True
		
		int arr1[]= {235,140,4};
		System.out.println(utf8Validation(arr1)); // Expected Result = False
	}
	
	private static boolean utf8Validation(int[] arr) {
		
		for(int i=0;i<arr.length;i++ ){
			int numOfBytes=0;
			if(arr[i] >= 255) {
				 return false;
			} else if((arr[i] & 128)==0 ) {
				numOfBytes=1;
			} else if( (arr[i] & 224)==192) {
				numOfBytes=2;
			} else if((arr[i] & 240)==224) {
				numOfBytes=3;
			} else if((arr[i] & 248)==240) {
				numOfBytes=4;
			} else {
				return false;
			}
			for(int j=1;j<numOfBytes;j++) {
				if(i+j >=arr.length) {
					return false;
				} else if((arr[i+j] & 192) !=128) {
					return false;
				}
			}
			i+=numOfBytes-1;
		}
		return true;
	}

}
