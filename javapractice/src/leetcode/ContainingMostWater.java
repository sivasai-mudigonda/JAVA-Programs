/**
* 
*/
package leetcode;

/**
 * @author u230107 LeetCode-11
 *         https://leetcode.com/problems/container-with-most-water/
 * 
 *         Given n non-negative integers a1, a2, ..., an, where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 *         which together with x-axis forms a container, such that the container
 *         contains the most water.
 * 
 *         Note: You may not slant the container and n is at least 2.
 * 
 *         Sol: Refer https://www.youtube.com/watch?v=cdRaaEYk6tI
 * 
 *         The container is a rectangle. So the amount of the water is
 *         determined by the width and height. The container’s width is right –
 *         left and height is the minimum value between left line height and
 *         right line height. Area = (right-left) * Min(leftHeight,rightHeight)
 *         MaxArea= Max(MaxArea,Area)
 * 
 *         Time Complexity = O(n) Space Complexity : o(1)
 *
 */
public class ContainingMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = maxAreaOfWaterContainer(height);
		System.out.println("MaxArea = " + maxArea); // Expected Output = 49
	}

	private static int maxAreaOfWaterContainer(int[] height) {
		int maxArea = 0;
		if (height == null) {
			return maxArea;
		}
		int leftIndex = 0;
		int rightIndex = height.length - 1;
		while (leftIndex < rightIndex) {
			int area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
			maxArea = Math.max(maxArea, area);

			if (height[leftIndex] < height[rightIndex]) {
				leftIndex++;
			} else {
				rightIndex--;
			}
		}
		return maxArea;
	}
}
