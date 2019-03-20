/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 */
/*
 * 
 * Refer https://www.youtube.com/watch?v=6PDtgHhpCHo
 * 
 * Time Complexity is O(SQRT(N))
 * 
 */
public class PrimeFactorisation {

	public static void main(String[] args) {
		primeFactorization(44);
	}

	private static void primeFactorization(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) { // Prime number cannot exceed sqrt of number
			if (n % i == 0) {
				int counter = 0;
				while (n % i == 0) {
					n /= 2;
					counter++;
				}
				System.out.println(i + " " + counter);
			}
		}
		if (n != 1) {
			System.out.println(n + " 1");
		}
	}

}