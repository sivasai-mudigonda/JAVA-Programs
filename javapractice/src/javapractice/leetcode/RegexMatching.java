package leetcode;

/**
 * 
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.'{sometimes called as ?} and '*'.

'.'{?} Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * 
 * 
 * Refer "https://www.youtube.com/watch?v=3ZDZ-N0EPV0"
 * Refer "https://www.youtube.com/watch?v=l3hda49XcDE"
 * 
 * Time Complexity = O(N^2) or O(MN) ., where M is text and N is pattern
 * Space Complexity = o(N^2) --> Two Dimentional boolean Array
 */
public class RegexMatching {

   /**
     * Dynamic programming technique for regex matching.
     */
    public boolean matchRegex(char[] text, char[] pattern) {
       boolean regExArr[][] = new boolean[text.length+1][pattern.length+1]; // By Default all values false.
       regExArr[0][0]=true;
       // Note: Regular expression cannot start with "*"
       // To handle row-1 for regex starting with "*a" kind of patterns.
       for(int i=1;i<regExArr[0].length;i++ ) {
    	   if(pattern[i-1]=='*') {
    		   regExArr[0][i]=regExArr[0][i-2];   // i-2 because as anything before "*"
    	   }
       }
       
       for(int i=1;i<regExArr.length;i++) {
    	   for(int j=1;j<regExArr[0].length;j++) {
    		   if(text[i-1]==pattern[j-1] || pattern[j-1]=='.' ){
    			   // Set left diagonal value from above 
    			   regExArr[i][j]=regExArr[i-1][j-1];
    		   } else if(pattern[j-1]=='*' ){
    			   regExArr[i][j]=regExArr[i][j-2]; // Same row, two col back
    			   if(pattern[j-2]=='.' || pattern[j-2]==text[i-1] ){ // compare current text(i-1) with previous char in pattern(j-2).
    				   regExArr[i][j]=regExArr[i-1][j] | regExArr[i][j]; // Bitwise operator- Any one true, output is True.
    			   }
    		   } else {
    			   regExArr[i][j]=false;
    		   }
    	   }
       }
       
       return regExArr[text.length][pattern.length]; // Last row,Last col will be the result.
    }

    public static void main(String args[]){
        RegexMatching rm = new RegexMatching();
        System.out.println(rm.matchRegex("Siva".toCharArray(),"Siva".toCharArray()));
        System.out.println(rm.matchRegex("Siva".toCharArray(),"Siva*a*b*".toCharArray()));
        System.out.println(rm.matchRegex("".toCharArray(),"a*b*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegex("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
        /**
         * Expected Output :
         * true
			true
			true
			true
			false
			false
			true
			true
			true
         */
    }
}
