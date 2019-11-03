/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author SivaM
*
* LeetCode Ques- 251 {Flatten 2D Vector}
* https://leetcode.com/problems/flatten-2d-vector/
*
* Implement an iterator to flatten a 2d vector.
*
	For example, Given 2d vector =
	[
	[1,2],
	[3],
	[4,5,6]
	]
	By calling next repeatedly until hasNext returns false,
	the order of elements returned by next should be: [1,2,3,4,5,6].
*
* Solution:
* Check if next element is present or not. {hasNext()}
* Take two pointers to iterate through array
*
* Time Complexity = O(N) - Iterate through array
* Space Complexity = o(1) - Constant space used
*/
public class Flatten_2D_Vector {

	/**
	 * @param args
	 */
	List<List<Integer>> vec2d;
	int xIndex;
	int yIndex;

	public static void main(String[] args) {
		Integer[][] arr = { { 1, 2 }, { 3 }, {}, { null }, { 4, 5, 6 } };
		List<List<Integer>> vec2d = Arrays.stream(arr).map(array -> Arrays.stream(array).collect(Collectors.toList()))
				.collect(Collectors.toList());
		Flatten_2D_Vector obj = new Flatten_2D_Vector(vec2d);
		while (obj.hasNext()) {
			System.out.print(obj.next() + " "); // Expected Output = [1,2,3,4,5,6]
		}
	}

	public Flatten_2D_Vector(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		xIndex = 0;
		yIndex = 0;
	}

	public Integer next() {
		if (!hasNext()) {
			return -1;
		}
// get value and increment yIndex for next element
		int val = vec2d.get(xIndex).get(yIndex);
		yIndex++;
		return val;
	}

	public boolean hasNext() {
		if (vec2d == null || vec2d.isEmpty()) {
			return false;
		}
		if (yIndex == vec2d.get(xIndex).size()) {
			yIndex = 0;
			xIndex++;
		}
		if (xIndex >= vec2d.size()) {
			return false;
		}
// if there are no elements in the array, increment xIndex and see if the elements are present in next row
		if (vec2d.get(xIndex).isEmpty()) {
			xIndex++;
			hasNext();
		}
// If current value is null, Move to next element
		if (vec2d.get(xIndex).get(yIndex) == null) {
			yIndex++;
			return hasNext();
		}
		return true;
	}
}
