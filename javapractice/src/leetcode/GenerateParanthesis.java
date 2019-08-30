/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 */
public class GenerateParanthesis {

	/**
	 * 
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses?
	 *
	 * Time Complexity = O(2^n)
	 * 
	 * Refer https://www.youtube.com/watch?v=yNpF3V11aXY
	 */
	public static void main(String[] args) {
		generateParathesis(3);
		/**
		 * Expected Output:
		 * [
			  "((()))",
			  "(()())",
			  "(())()",
			  "()(())",
			  "()()()"
			]
		 */
	}
	
	private static void generateParathesis(int n) {
		List<String> res= new LinkedList<>();
		String str = "";
		dfs(n,str,res,0,0);
		System.out.println(res.toString());
	}
	
	// Using DFS {BackTracking}
	private static void dfs(int n, String str, List<String> res, int open, int close) {
		if(close==n) {
			res.add(str);
			return;
		}
		
		if(open<n) {
			dfs(n,str+"(", res,open+1,close);
		}
		
		if(close<open) {
			dfs(n,str+")",res,open,close+1);
		}
	}

}
