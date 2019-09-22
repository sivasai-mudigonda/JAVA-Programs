/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 118 {Pascal's Triangle}
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
		Example:
		
		Input: 5
		Output:
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
 *
 *
 * Time Complexity = O(n^2) - each unit/row taking n units of time. 
 * Space Complexity = o(n^2) - each unit/row taking n spaces
 */
public class PascalTriangle {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> resLi = generate(5);
		resLi.forEach(System.out::println);
		/**
		 * Expected Output:
		 * [1]
		 * [1, 1]
		 * [1, 2, 1]
		 * [1, 3, 3, 1]
		 * [1, 4, 6, 4, 1]
		 */
	}
	
	private static List<List<Integer>> generate(int numRows) {
		if(numRows==0) {
			return new LinkedList<>();
		}
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> firstLi = new LinkedList<>();
		firstLi.add(1); // First row of Pascal triangle is always one
		res.add(firstLi);
		for(int row=1;row<numRows;row++){
			List<Integer> li = new LinkedList<>();
			li.add(1); // Pascal Triangle's first row is always one.
			for(int col=1;col<row;col++){
				int num = res.get(row-1).get(col-1) + res.get(row-1).get(col); // Above row's, current column + Previous Column
				li.add(num);
			}
			li.add(1); // Pascal Triangle's last row is always one.
			res.add(li);
		}
		return res;
    }
}
