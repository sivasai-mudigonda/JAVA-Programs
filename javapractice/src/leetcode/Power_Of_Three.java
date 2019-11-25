/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 326 {Power of Three} - Easy
 * https://leetcode.com/problems/power-of-three/
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 

	Example 1:
	Input: 27
	Output: true

	Example 2:
	Input: 0
	Output: false

	Example 3:
	Input: 9
	Output: true

	Example 4:
	Input: 45
	Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * Time Complexity = O(N) - Linear Time
 * Space Complexity = o(1) - Constant space
 */
public class Power_Of_Three {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Power_Of_Three obj = new Power_Of_Three();
		
		int n= 27;
		System.out.println("Is Power of Three = " +obj.isPowerOfThree(n)); // Expected Output = True
		System.out.println("Is Power of Three = " +obj.isPowerOfThree_NoLoop(n)); // Expected Output = True
		
		n = 0;
		System.out.println("Is Power of Three = " +obj.isPowerOfThree(n)); // Expected Output = False
		System.out.println("Is Power of Three = " +obj.isPowerOfThree_NoLoop(n)); // Expected Output = False
		
		n = 9;
		System.out.println("Is Power of Three = " +obj.isPowerOfThree(n)); // Expected Output = True
		System.out.println("Is Power of Three = " +obj.isPowerOfThree_NoLoop(n)); // Expected Output = True
		
		n = 45;
		System.out.println("Is Power of Three = " +obj.isPowerOfThree(n)); // Expected Output = False
		System.out.println("Is Power of Three = " +obj.isPowerOfThree_NoLoop(n)); // Expected Output = False
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
		if (n < 1 ){
            return false;
		}
        while(n%3==0 ){
       		n = n/3;
        }
        return n==1;
    }
	
	/**
	 * 
	 * @param n
	 * @return
	 * 
	 * Time Complexity = O(1)
	 * 
	 */
	public boolean isPowerOfThree_NoLoop(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
       //  OR
       // return n > 0 && 1162261467 % n == 0;
        // 1162261467, Expressed as 3^19. 
        // Biggest value that can be expressed as power of three that can fit in int.
    }
}
