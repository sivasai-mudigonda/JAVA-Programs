/**
 * 
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SIVA SAI
 *
 */
public class MergeSort { 
	// Divide & Merge Algorithm
	// BEST CASE Time Complexity = O(nlogn)
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr= {2,1,4,21,9,56,43};
		List<Integer> unsortedList = Arrays.asList(arr);
		unsortedList.forEach(System.out::println);
		System.out.println("******");
		MergeSort ms= new MergeSort();
		List<Integer> sortedList = ms.mergeSort(unsortedList);
		sortedList.forEach(x->System.out.println(x));
	}

     public List<Integer> mergeSort(List<Integer> unsortedList){ // This function achieves Divide functionality
    	 if(unsortedList.size()<2) {
    		 return unsortedList;
    	 }
    	 List<Integer> leftHalf = unsortedList.subList(0, unsortedList.size()/2);
    	 List<Integer> rightHalf = unsortedList.subList(unsortedList.size()/2, unsortedList.size());
    	 return merge(mergeSort(leftHalf),mergeSort(rightHalf));
     }
     
     public List<Integer> merge(List<Integer> leftHalf, List<Integer> rightHalf){ // This function achieves Merge functionality
    	 Integer leftPtr=0; // pointer to iterate left half
    	 Integer rightPtr=0;  // pointer to iterate right half
    	 List<Integer> sortedList = new ArrayList<Integer>(leftHalf.size()+rightHalf.size());
    	 while(leftPtr<leftHalf.size() && rightPtr<rightHalf.size() ){
    		 if(leftHalf.get(leftPtr) < rightHalf.get(rightPtr)) {
    			// To merge Left & Right lists.
    			 sortedList.add(leftHalf.get(leftPtr));
    			 leftPtr++;
    		 } else {
    			 sortedList.add(rightHalf.get(rightPtr));
    			 rightPtr++;
    		 }
    	 }
    	 while(leftPtr<leftHalf.size() ){
    		// To insert remaining pending elements if there are any in leftHalf list.
    		 sortedList.add(leftHalf.get(leftPtr));
    		 leftPtr++;
    	 }
    	 while(rightPtr<rightHalf.size() ){
    		// To insert remaining pending elements if there are any in rightHalf list.
    		 sortedList.add(rightHalf.get(rightPtr));
    		 rightPtr++;
    	 }
    	 return sortedList;
     }
}

/*
 * 
 * o = 2,1,4

---------------
Label-1:
n=2,1,4
l=2
r=1,4

call L2(l)

return back of control to l1 with merge(2,?)

call L3(r) --> returned 1,4

call merge (2,(1,4))--> returns 1,2,4 which is final output

----------------
Labe-2:
if n=2
return 2;

if n=1
return 1;

if n=4
return 4;
----------------
Label-3
n=1,4
l=1
r=4

call L2(l); returns 1; i.e.,merge(1,?)

call L2(r); returns 4; i.e;merge(1,4)

call merge(1,4)-- returns (1,4) to L1
----------------
 */
