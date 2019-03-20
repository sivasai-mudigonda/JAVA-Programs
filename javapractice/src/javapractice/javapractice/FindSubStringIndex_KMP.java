/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */
// Refer https://www.youtube.com/watch?v=V5-7GzOfADQ
// KMP Algorithm
public class FindSubStringIndex_KMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB"; 
        String pat = "BACDAB"; 
        findIndexSubString(txt,pat);
	}
	
	private static void findIndexSubString(String str, String pattern) {
		if(pattern==null || pattern.length()==0) {
			System.out.println("Pattern is empty");
			System.exit(0);
		}
		int[] lps= calPieTable(pattern);
		
		int i=0; // To iterate over str
		int j=0; // To iterate over pattern
		int startIndex=0;
		while(i<str.length() ){
			if(str.charAt(i) == pattern.charAt(j) ){
				i++;
				j++;
			}
			if(j==pattern.length() ){
				System.out.println("Pattern Found");
				System.out.println("start index of sub string is " +lps[j-1]);
				startIndex=i-j-1;
				System.out.println("start Index =" +startIndex);
				j=lps[j-1];
				System.exit(0);
			} else if(i<str.length() && str.charAt(i) != pattern.charAt(j)) {
				if(j==0) {
					i++;
				} else {
					j=lps[j-1];
				}
			}
		}
	}
	
	private static int[] calPieTable(String pattern) {
		int[] lps = new int[pattern.length()];
		lps[0]=0;
		int i=1; // Index of Pie table
		int j=0; // Values for Pie Table 		
		while(i<pattern.length() ){
			if(pattern.charAt(j)==pattern.charAt(i)) {
				j++;
				lps[i]=j;
				i++;
			} else {
				if(j!=0 ) {
					j=lps[j-1];
				} else {
					lps[i]=j; // Set zero
					i++;
				}
			}
		}
		return lps;
	}

}
