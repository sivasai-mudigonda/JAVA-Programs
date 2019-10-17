/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 204 {Count Primes}
 * https://leetcode.com/problems/count-primes/
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
	Example:
	Input: 10
	Output: 4
	Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * Solution:
 * Eliminates all the composite numbers, 
 * so that you are finally left with only the prime ones. 
 * We start with a number, if it is prime, then we mark all its multiples. 
 * We do this iteratively.
 * A little optimization would be to only check till the square root of ‘n’, 
 * as the numbers greater than this will have multiples greater than ‘n’
 * 
 * Refer example in below link {Sieve_of_Eratosthenes}
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * Time Complexity = O(n log log n) - Shrinking by a Square Root at each iteration.
 * Space Complexity =o(N) = boolean array of n elements
 *
 */
public class CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		System.out.println("prime numbers less than 10 = " +obj.countPrimes(10)); // Expected Output = 4
		System.out.println("prime numbers less than 30 = " +obj.countPrimes(30)); // Expected Output = 10
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 * 
	 */
	public int countPrimes(int n) {
        if(n<=2 ){
        	return 0;
        }
        boolean[] composites = new boolean[n];
        int cntPrimes=0;
        int i=2; // First Prime number is 2
        while(i<Math.sqrt(n)) {
        	if(!composites[i] ){ // Not a composite number, that means it is a prime number
        		for(int j=i+i;j<n;j+=i) {
        			composites[j]=true;
        		}
        	}
        	i++;
        }
        for(int k=2;k<n;k++) {
        	if(!composites[k]) { // Not a composite number, that   means it is a prime number
        		cntPrimes++;
        	}
        }
        return cntPrimes;
    }
}