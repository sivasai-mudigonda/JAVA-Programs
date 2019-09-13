/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 */
public class FindMissingSmallestPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	private static int findMissingSmallestPositive(int nums[]){
		int i=0;
		while(i<nums.length) {
			if(nums[i]<=0 || nums[i]>nums.length){
				i++; // If -ve number or >nums.length, need not do anything
			} else if(nums[nums[i]-1]!=nums[i]){ // Bucket Sorting
				swap(nums,i,nums[i]-1);
			} else {
				i++;
			}
		}
		i=0;
		while(i<nums.length && nums[i]==i+1) {
			i++; // If number is present, continue searching by incrementing i
		}
		return i+1;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
