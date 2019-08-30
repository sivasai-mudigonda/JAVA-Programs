/**
 * 
 */
package practice;

import java.util.HashMap;

/**
 * @author SIVA SAI
 * Refer https://www.hackerrank.com/challenges/linkedin-practice-divisible-sum-pairs/forum
 * 
 * Time Complexity is O(N)
 */
public class TwoDivisible {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
        int n = 2; // Array Length
        int k = 2; // Reminder
        int a[] = {8,10}; // Array
        
        /**
         * For any divisor k, you can get k different remainders : 0, 1, 2 .. (k-1). 
         * The idea is to count the number of elements with specific remainder.
         * Suppose the list is 14 4 7 9 8 3 17 12 and k = 4. Then
				Remainder       Integers        Count
				---------       ---------       ------
				    0           4, 8, 12        3
				    1           9, 17           2
				    2           14              1
				    3           3, 7            2
         */
        HashMap<Integer,Integer> modHash = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++){
            if(modHash.containsKey(a[i]%k)){
                modHash.put(a[i]%k, modHash.get(a[i]%k)+1);
            }else{
                modHash.put(a[i]%k,1);
            }         
        }
        int counter = 0;
        
        /**
         * Values with remainder 0, can be paired with themselves. 
         * That's because even after addition the remainder will remain 0. If there are c such integers, no. of pairs = c*(c-1)/2
         */
        if(modHash.containsKey(0) ) { 
        	counter += modHash.get(0)*(modHash.get(0)-1)/2; // c*(c-1)/2
        }
        
        for (int mod_i = 1; mod_i < (k+1)/2; mod_i++){
        	/**
        	 *  Values with remainder r can be paired with values with remainder k-r, since, remainder of sum becomes k i.e. 0.
        	 */
            if (modHash.containsKey(mod_i) && modHash.containsKey(k-mod_i)){
                counter += modHash.get(mod_i) * (modHash.get(k-mod_i));
             }
        }
        
        /**
         *  Finally, values with remainder exactly k/2, can be paired with themselves.
         *  (Calculation same as remainder 0 values) 
         */
        if(k%2 == 0 && modHash.containsKey(k/2)) {
        	counter += modHash.get(k/2)*(modHash.get(k/2)-1)/2;
        }
        
        System.out.println(counter);
    }
}
