/**
 * 
 */
package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.annotation.Resource;

/**
 * @author SivaM
 * 
 * Leet-code Ques - 341 {Flatten Nested List Iterator} {Medium}
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
	Example 1:
	
	Input: [[1,1],2,[1,1]]
	Output: [1,1,2,1,1]
	Explanation: By calling next repeatedly until hasNext returns false, 
	             the order of elements returned by next should be: [1,1,2,1,1].
	
	Example 2:
	Input: [1,[4,[6]]]
	Output: [1,4,6]
	Explanation: By calling next repeatedly until hasNext returns false, 
	             the order of elements returned by next should be: [1,4,6].
 *
 *
 * Time Complexity =  O(N) - Loop through List<NestedInteger>
 * Space Complexity = o(N) - Queue used to store Integers
 *
 */
@Resource(name = "Flatten_Nested_List_Iterator", description = "Flatten Nested List Iterator")
public class NestedIterator implements Iterator<Integer> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<NestedInteger> nestedList = new LinkedList<>();
		
		List<NestedInteger> subLi = new LinkedList<>();
		subLi.add(new NestedIntegerImpl(1));
		subLi.add(new NestedIntegerImpl(1));
		
		nestedList.add(new NestedIntegerImpl(subLi));
		nestedList.add(new NestedIntegerImpl(2));
		nestedList.add(new NestedIntegerImpl(subLi));
	    
		NestedIterator obj = new NestedIterator(nestedList);
	    obj.print(obj); // Expected Output = [1,1,2,1,1] 
	    
	    System.out.println("*************************************");
	    
	    nestedList = new LinkedList<>();
		
	    subLi = new LinkedList<>();
		subLi.add(new NestedIntegerImpl(4));
		
		List<NestedInteger> sub_subLi = new LinkedList<>();
		sub_subLi.add(new NestedIntegerImpl(6));
		subLi.add(new NestedIntegerImpl(sub_subLi));
		
		nestedList.add(new NestedIntegerImpl(1));
		nestedList.add(new NestedIntegerImpl(subLi));
		
		obj = new NestedIterator(nestedList);
	    obj.print(obj); // Expected Output = [1,4,6]
	}
	
	void print(NestedIterator it) {
		System.out.print("Flatten List = ");
		while (it.hasNext() ){
			System.out.print(it.next() +" ");
		}
		System.out.println();
	}
	
	Iterator<Integer> it;
	public NestedIterator(List<NestedInteger> nestedList) {
		if(nestedList==null) {
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		helper(nestedList,queue);
		it = queue.iterator();
	}
	
	/**
	 * 
	 * @param nestedList
	 * 
	 * Apply DFS
	 */
	private void helper(List<NestedInteger> nestedList, Queue<Integer> queue) {
		for(NestedInteger nestedInt : nestedList) {
			if(nestedInt.isInteger() ) {
				queue.offer(nestedInt.getInteger());
			} else {
				helper(nestedInt.getList(),queue);
			}
		}
	}

	@Override
	public Integer next() {
		return it.next();
		//return !queue.isEmpty()?queue.poll():null;
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
		//return !queue.isEmpty()?true:false;
	}
}