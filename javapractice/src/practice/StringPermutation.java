/**
 * 
 */
package practice;

/**
 * @author SIVA SAI
 *
 */

public class StringPermutation 
{ 
    public static void main(String[] args) 
    { 
        String str = "ABC"; 
        int n = str.length(); 
        StringPermutation permutation = new StringPermutation(); 
        permutation.permute(str,0,n-1); 
    } 
  
    /** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
 // Time Complexity =  O(n*n!)
    // BackTracking method
    private void permute(String str,int s,int e) 
    {
    	if(s==e) {
    		System.out.println(str);
    	}
    	
    	for(int i=s;i<=e;i++ ){
    		str = swap(str,s,i);
    		permute(str,s+1,e);
    		str= swap(str,s,i);
    	}
    } 
  
    /** 
     * Swap Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
     private static String swap(String str,int s,int e){
    	 char[]chArr= str.toCharArray();
    	 char temp=chArr[s];
    	 chArr[s]=chArr[e];
    	 chArr[e]=temp;
    	 return String.valueOf(chArr);
     }
  
} 