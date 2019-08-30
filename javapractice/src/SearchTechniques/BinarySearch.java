/**
 * 
 */
package SearchTechniques;

import java.util.Arrays;
import java.util.List;
/**
 * @author SIVA SAI
 *
 */
// Binary Search Implementation
public class BinarySearch {
	// Very effective to search element on Sorted list
	// BEST CASE TIME COMPLEXITY = O(n)
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr= {45,89,196,342,765,971};
		List<Integer> sortedList= Arrays.asList(arr);
		BinarySearch bs= new BinarySearch();
		
		Integer value= 196;
		boolean hasElement= bs.binarySearch(sortedList,value);
		System.out.println("Has Element = "+hasElement);
		
		value=191;
		hasElement= bs.binarySearch(sortedList,value);
		System.out.println("Has Element = "+hasElement);
	}
	
	public boolean binarySearch(List<Integer> searchList, Integer value) {
		if(searchList==null || searchList.isEmpty()) {
			return false;
		}
		Integer compare= searchList.get(searchList.size()/2);
		if(value.equals(compare) ){ 
			// To compare reference type use equals
			// To compare primitive types use ==
			return true;
		}
		if(value<compare) {
			// Search in first half of list.
			return binarySearch(searchList.subList(0, searchList.size()/2), value);
		} else {
			// Search in first second of list.
			return binarySearch(searchList.subList(searchList.size()/2+1,searchList.size()), value);
		}
	}

}
