/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */

/** Refer https://www.youtube.com/watch?v=_nCsPn7_OgI
 * Also refer 
 * https://www.geeksforgeeks.org/java-program-for-longest-palindromic-subsequence-dp-12/
 * 
 *
 */


public class LongestPalindromeSubSequence {

	// Dynamic Programming
	//  Time Complexity = O(n^2)
	private static int lpsDynamicProgram(char []charArr){
		if(charArr==null ) {
			return 0;
		}
		
       int [][] result = new int[charArr.length][charArr.length];
       int n= result.length;
       
       // Make all Diagonals to one.
       for(int row=0;row<n;row++) {
    	   result[row][row]=1;
       }
       
       // cl represents substring
       
       for(int cl=2;cl<=n;cl++) {
    	   for(int row=0;row<n-cl+1;row++) {
    		   int col=row+cl-1;
    		   if(charArr[row]==charArr[col] && cl==2 ) {
    			   result[row][col]=2;
    		   } else if(charArr[row]==charArr[col]) {
    			   // As characters are matching, +2 need to be added.
    			   result[row][col]= result[row+1][col-1]+2;
    		   } else {
    			   result[row][col]=Math.max(result[row][col-1], result[row+1][col]);
    		   }
    		   
    	   }
       }
       
       // Result will be at first row, last column
       return result[0][n-1];
    }
	
	// Recursive Programming.
	private static int lpsRecursiveProgram(char []charArr, int row, int col){
		 // Base Case 1: If there is only 1 character
		if(row==col) {
			return 1;
		}
		
		// Base Case 2: If there are only 2 characters and both are same 
        if (charArr[row] == charArr[col] && row + 1 == col) { 
            return 2; 
        }
        
		 // If the first and last characters match
		if(charArr[row]==charArr[col] ) {
			return lpsRecursiveProgram(charArr,row+1,col-1) +2;
		}
		// If the first and last characters do not match 
		return Math.max(lpsRecursiveProgram(charArr,row,col-1), lpsRecursiveProgram(charArr,row+1,col));
	}
	
	public static void main(String[] args) {
		String str = "agbdba";
		System.out.println(lpsDynamicProgram(str.toCharArray()));
		System.out.println(lpsRecursiveProgram(str.toCharArray(),0,str.length()-1) );
		
		str = "GEEKSFORGE";
		System.out.println(lpsDynamicProgram(str.toCharArray()));
		System.out.println(lpsRecursiveProgram(str.toCharArray(),0,str.length()-1) );
	}
}
