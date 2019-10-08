/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SivaM
 *
 */
public class FactorsCombination {

	/**
	 * @param args
	 * LeetCode Ques - 254 {Factor Combinations}
	 * https://leetcode.com/problems/factor-combinations/
	 * 
	 * Numbers can be regarded as product of its factors. 
	 * 
	   For example,
  		8 = 2 x 2 x 2 and 2 x 4.
	 * 
	 * Write a function that takes an integer n and return all possible combinations of its factors.
	 * Note:
	 * You may assume that n is always positive.
	 * Factors should be greater than 1 and less than n.
	 * 
	 * Time Complexity = O(N) - Looping through n-1 
	 * Space Complexity = o(p) - where p is the space used by call stack for recursive calls for n%i==0.
	 */
	public static void main(String[] args) {
		FactorsCombination obj = new FactorsCombination();
		System.out.println(obj.getFactors(8));
	}
	
	 public List<List<Integer>> getFactors(int n) {
		 List<List<Integer>> resultLi = new ArrayList<>();
		 List<Integer> subLi = new ArrayList<>();
		 getFactorsHelp(2,1,n,subLi,resultLi);
		 return resultLi;
	 }
	 
	 /**
	  * 
	  * @param start
	  * @param product
	  * @param n
	  * @param subLi
	  * @param resultLi
	  * 
	  * DFS + BackTracking
	  */
	 private void getFactorsHelp(int start, int product, int n,List<Integer> subLi,List<List<Integer>> resultLi) {
		 if(start>n || product>n ){
			 return; // No point going forward when start or product is greater than n
		 }
		 
		 if(product==n) { // there a valid combination in subLi which gives n, therefore add that combination to result list.
			 List<Integer> tempLi = new ArrayList<>(subLi);
			 resultLi.add(tempLi);
			 return;
		 }
		 
		 for(int i=start;i<n;i++) {
			 if(i*product>n) {
				 break;
			 }
			 if(n%i==0 ){
				 subLi.add(i); // Add i to list and check if there is any number that is greater than i and that number when multiplied with product gives 8.
				 getFactorsHelp(i,i*product,n,subLi,resultLi);
				// We have explored the possibility with top most element in list, So, now lets explore with the number below top.
				 // Hence remove from list.
				 subLi.remove(subLi.size()-1);
			 }
		 }
	 }

}
