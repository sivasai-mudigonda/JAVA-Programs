/**
 * 
 * LeetCode- 158 Problem
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function may be called multiple times.

 * 
 * 
 * Refer "https://www.youtube.com/watch?v=5gO5syMOKnI" {For Video Explanation}
 * Refer "https://zhuhan0.blogspot.com/2017/09/leetcode-158-read-n-characters-given.html" {For Code}
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 */
public class ReadNCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     * 
     * Time Complexity = O(n^2)
     * Space Complexity = O(1)
     */
	public int read(char[] buf, int n) {
		int total=0;
		char[] chArr= new char[4]; // To store 4 bits which are read.
		int chArrIndex=0;
		int bufCnt=0;
		while(total < n) {
			if(chArrIndex==0) {
				bufCnt = read4(chArr);
			}
			if(bufCnt==0 ){
				break;
			}
			 while(total < n && chArrIndex < bufCnt) {
				 buf[total] = chArr[chArrIndex];
				 chArrIndex++;
				 total++;
			 }
			 if(chArrIndex == bufCnt) {
				 chArrIndex=0;
			 }
		}
		return total;
	}
		
	private static int read4(char[] buf4){
		int i=10;
		return i; // Total characters
	}
}
