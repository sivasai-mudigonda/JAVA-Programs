/**
 * 
 */
package javapractice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SIVA SAI
 *Given an array of distinct elements and a number x, 
 *find if there is a pair with a product equal to x?
 *
 *Refer https://www.geeksforgeeks.org/pair-with-given-product-set-1-find-if-any-pair-exists/
 */
public class CheckProductExistsArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]= {10, 20, 9, 40};
		int target=400;
		System.out.println(checkProduct(arr,target));
		
		int arr1[]= {10, 20, 9, 40};
		target=190;
		System.out.println(checkProduct(arr1,target));
	}
	
	// Assuming that target is an integer.
	private static  boolean checkProduct(int arr[], int target) {
		if(arr==null || arr.length==0) {
			return false;
		}
		Set<Integer> set= new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			
			// If target is zero.
			if(target==0 && arr[i]==0 ) {
				return true;
			}
			
			if(target%arr[i]==0) // Integer check
			{
				if(set.contains(target/arr[i]) ) {
					return true;
				}
				set.add(arr[i]);
			}
		}
		return false;
	}

}
