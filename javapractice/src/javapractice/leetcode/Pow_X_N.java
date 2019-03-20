/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 *Implement pow(x, n), which calculates x raised to the power n (xn)?
 *
 *Refer "https://www.youtube.com/watch?v=wAyrtLAeWvI"
 *Refer "https://www.youtube.com/watch?v=VHcZtdp5054" --> Time Complexity Analysis
 *Refer "https://www.youtube.com/watch?v=yEQq3t3T_J0"
 *
 *Time Complexity = O(N)
 *Space Complexity = O(1)
 */
public class Pow_X_N {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=10;
		double result=0.0;
		if(checkNegitive(n) ){
			result = 1/myPow(2.0,-n);
		} else {
			result = myPow(2.0,n);
		}
		System.out.println("Result = "+result); // Expected output = 1024.00000
		
		n=3;
		if(checkNegitive(n) ){
			result = 1/myPow(2.1,-n);
		} else {
			result = myPow(2.1,n);
		}
		System.out.println("Result = "+result); // Expected output = 9.26100
		
		n=-2;
		if(checkNegitive(n) ){
			result = 1/myPow(2.0,-n);
		} else {
			result = myPow(2.0,n);
		}
		System.out.println("Result = "+result); // Expected output = 0.25000
	}
	
	private static boolean checkNegitive(int n) {
		if(n<0) {
			return true;
		}
		return false;
	}

	 private static double myPow(double x, int n) {
		 if(n==0) {
			 return 1; // break condition for recursion
		 } else if(n%2==0) {
			// For Even it is x^(n/2) * x^(n/2)
			 double res= myPow(x,n/2);
			 return res*res;  
		 } else {
			// For Odd it is x * x^(n-1)
			 return x *myPow(x,n-1);
		 }
	 }

}
