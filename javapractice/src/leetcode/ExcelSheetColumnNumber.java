/**
 * 
 */
package leetcode;

// import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 171 {Excel Sheet Column Number}
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
	For example:
	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
	    ...
	Example 1:
	
	Input: "A"
	Output: 1
	Example 2:
	
	Input: "AB"
	Output: 28
	Example 3:
	
	Input: "ZY"
	Output: 701
 *
 * Time Complexity = O(N) - N is each character in the String
 * Space Complexity = o(1) - Constant space, No extra space used
 */
public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
		System.out.println("Excel Sheet Column Number = "+obj.titleToNumber("A")); //Expected Result =  1
		System.out.println("Excel Sheet Column Number = "+obj.titleToNumber("AB")); //Expected Result =  28
		System.out.println("Excel Sheet Column Number = "+obj.titleToNumber("ZY")); //Expected Result = 701
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 * 
	 */
	public int titleToNumber(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		int result=0;
        for(char c: s.toCharArray()){
            result = 26*result+(c-'A')+1;
        }
		return result;
		
		/**
		 * Below code also works, but decreases execution speed
		 * To understand more about AtomicInteger, Refer
		 * http://tutorials.jenkov.com/java-util-concurrent/atomicinteger.html#setting-the-atomicinteger-value
		 * 
		 * To understand about how to use external variable in Lambda expression, refer
		 * https://stackoverflow.com/questions/30026824/modifying-local-variable-from-inside-lambda
		 * 
		AtomicInteger result = new AtomicInteger(0);
				s.chars().forEach(num->{
					int res = 26*result.get()+(num-'A')+1;
					result.set(res);
				});
				return result.intValue();
		*/
	}
}
