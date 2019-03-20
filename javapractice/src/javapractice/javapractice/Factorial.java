package javapractice;

/**
 * @author u230107
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(calFact(6));
		System.out.println(calFactRecursive(6));
	}

	// Loop
	private static int calFact(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// Recursion
	private static int calFactRecursive(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return n * calFactRecursive(n - 1);
	}

}