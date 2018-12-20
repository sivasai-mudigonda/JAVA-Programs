package interviews;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(arr3));
	}

	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
			return null;
		} else if ((arr1 == null || arr1.length == 0) && (arr2 != null && arr2.length != 0)) {
			return arr2;
		} else if ((arr2 == null || arr2.length == 0) && (arr1 != null && arr1.length != 0)) {
			return arr1;
		}
		int arr3[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}

		// Remaining Elements
		while (i < arr1.length) {
			arr3[k] = arr1[i];
			k++;
			i++;
		}

		while (j < arr2.length) {
			arr3[k] = arr2[j];
			k++;
			j++;
		}
		return arr3;
	}

}