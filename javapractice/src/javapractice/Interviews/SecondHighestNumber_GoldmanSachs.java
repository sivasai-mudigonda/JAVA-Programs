package interviews;

public class SecondHighestNumber_GoldmanSachs {

	public static void main(String[] args) {
		int[] arr = { 35, 90, 12, 7, 56, 77 };
		int secondHigh = secondHighestNum(arr);
		System.out.println("Second High = " + secondHigh); // Expected output = 77
	}

	private static int secondHighestNum(int[] arr) {
		int secondHigh = 0;
		if (arr == null || arr.length == 0) {
			return secondHigh;
		}

		int firstHigh = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstHigh) {
				secondHigh = firstHigh;
				firstHigh = arr[i];
			}

			if (arr[i] > secondHigh && arr[i] < firstHigh) {
				secondHigh = arr[i];
			}
		}
		return secondHigh;
	}
}
