/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 *
 *Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining?
 *
 *eg:
 *Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *Output: 6
 *
 *
 *Refer "https://www.youtube.com/watch?v=pq7Xon_VXeU"
 *Refer "https://www.youtube.com/watch?v=HmBbcDiJapY"
 *
 *Time Complexity = O(N)
 *Space Complexity = o(1)
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		int result=trap(height);
		System.out.println("Result = "+result); // Expected Output=6
		
		int[] height2= {7,1,4,0,2,8,6,3,5};
		result=trap(height2);
		System.out.println("Result = "+result); // Expected Output=23
	}
	
	private static int trap(int[] height) {
        int result=0;
        if(height==null || height.length==0) {
        	return 0;
        }
        int left_max=0;
        int right_max=0;
        int left=0;
        int right= height.length-1;
        while(left<right) {
        	if(height[left]<height[right]) {
        		if(height[left] >= left_max) {
        			left_max=height[left];
        		} else {
        			result+= left_max - height[left];
        		}
        		left++;
        	} else {
        		if(height[right] > right_max) {
        			right_max = height[right];
        		} else {
        			result+=right_max - height[right];
        		}
        		right--;
        	}
        }
        return result;
    }
}
