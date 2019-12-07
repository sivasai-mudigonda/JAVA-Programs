package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
* @author u230107
*
* Leet-code Ques - 384 {Shuffle an Array} {Medium}
* https://leetcode.com/problems/shuffle-an-array/
*
* Shuffle a set of numbers without duplicates.
*
	Example:
	// Init an array with set 1, 2, and 3.
	int[] nums = {1,2,3};
	Solution solution = new Solution(nums);
	
	// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
	solution.shuffle();
	
	// Resets the array back to its original configuration [1,2,3].
	solution.reset();
	
	// Returns the random shuffling of array [1,2,3].
	solution.shuffle();
*
* Solution:
* Shuffle: {Using Fisher–Yates shuffle Algorithm}
* 1.> On each iteration of the algorithm, we generate a random integer between the current index and the last index of the array.
* 2.> Then, we swap the elements at the current index and the chosen index - this simulates drawing (and removing) the element from the hat,
* as the next range from which we select a random index will not include the most recently processed one.
*
* Reset:
* Using clone method.
*
* Time Complexity = O(N) - Loop through N elements present shuffleArray in shuffle method.
* Space Complexity = o(1) - Constant Space
*
*/

public class Shuffle_Array {
	
	/**
	* @param args
	*
	* Your Solution object will be instantiated and called as such:
	* Solution obj = new Solution(nums);
	* int[] param_1 = obj.reset();
	* int[] param_2 = obj.shuffle();
	*
	*/
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Shuffle_Array obj = new Shuffle_Array(nums);
		// Arrays.stream(obj.shuffle()).forEach(i->System.out.print(i+"\t"));
		// Arrays.stream(obj.shuffle()).forEach(System.out::print);
		System.out.println("" + Arrays.toString(obj.shuffle())); // Expected Result could be 3, 2, 1 {shuffled}
		System.out.println("" + Arrays.toString(obj.reset())); // Expected Result = 1, 2, 3
		System.out.println("" + Arrays.toString(obj.shuffle())); // Expected Result could be 3, 1, 2 {shuffled}
		System.out.println("" + Arrays.toString(obj.reset())); // Expected Result = 1, 2, 3

		System.out.println("*******************************");
		System.out.println("" + Arrays.toString(obj.shuffle_Using_Collections())); // Expected Result could be 3, 2, 1
																					// {shuffled}
		System.out.println("" + Arrays.toString(obj.reset())); // Expected Result = 1, 2, 3
		System.out.println("" + Arrays.toString(obj.shuffle_Using_Collections())); // Expected Result could be 3, 1, 2
																					// {shuffled}
		System.out.println("" + Arrays.toString(obj.reset())); // Expected Result = 1, 2, 3
	}
	
	Random rand;
	int[] original_Array;
	int[] shuffleArray;
	
	/**
	*
	* @param nums
	*
	* Initialize your data structure here.
	*
	*/
	public Shuffle_Array(int[] nums) {
		original_Array = nums;
		shuffleArray = nums.clone(); // Creates new copy of nums.
		rand = new Random();
	}

	/**
	*
	* @return
	*
	* Resets the array to its original configuration and return it.
	*
	*/
	public int[] reset() {
		if (original_Array == null || original_Array.length == 0) {
			return new int[0];
		}
		shuffleArray = Arrays.copyOf(original_Array, original_Array.length);
		return shuffleArray;
	}

	/**
	*
	* @return
	*
	* Returns a random shuffling of the array.
	*
	*/
	public int[] shuffle() {
		if (shuffleArray == null || shuffleArray.length == 0) {
			return new int[0];
		}
		for (int i = 0; i < shuffleArray.length; i++) {
			int shuffleIndex = rand.nextInt(shuffleArray.length);
			swap(i, shuffleIndex);
		}
		return shuffleArray;
	}

	/**
	*
	* @param a
	* @param b
	*
	* SWAP elements in array
	*
	*/
	private void swap(int a, int b) {
		int temp = shuffleArray[a];
		shuffleArray[a] = shuffleArray[b];
		shuffleArray[b] = temp;
	}

	/**
	*
	* @return
	*
	* Approach-2 for shuffling
	* Using Collections.shuffle
	*
	* We can create a list from the array and then use the Collections class shuffle() method to shuffle its elements.
	* Then convert the list to the original array.
	*
	*/
	public int[] shuffle_Using_Collections() {
		if (shuffleArray == null || shuffleArray.length == 0) {
			return new int[0];
		}
		List<Integer> li = Arrays.stream(shuffleArray).mapToObj(Integer::new).collect(Collectors.toList());
		Collections.shuffle(li);
		shuffleArray = li.stream().mapToInt(Integer::intValue).toArray();
		return shuffleArray;
	}
}
