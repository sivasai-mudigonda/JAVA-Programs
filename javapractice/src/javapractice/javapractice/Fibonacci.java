package javapractice;

/**
 * @author u230107
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(calFibSeries(10));
		System.out.println(calFibSeriesRecurssion(10));
		System.out.println(calFibSeriesLoop2(10));
	}

	// Loop-1- High space consumption.
	public static long calFibSeries(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		long f[] = new long[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	// Loop-2- Space optimized
	public static long calFibSeriesLoop2(int n) {
		long prev1 = 0;
		long prev2 = 1;
		long sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = prev1 + prev2;
			prev1 = prev2;
			prev2 = sum;
		}
		return prev2;
	}

	// Recursion
	private static long calFibSeriesRecurssion(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		return calFibSeriesRecurssion(n - 1) + calFibSeriesRecurssion(n - 2);
	}

	// BEST WAY
	// Fn = {[(SQRT(5) + 1)/2] ^ n} / SQRT(5)- USE this formula for fib series.
}