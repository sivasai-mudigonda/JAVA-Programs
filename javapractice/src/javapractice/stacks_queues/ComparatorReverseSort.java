package stacks_queues;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ComparatorReverseSort {
	
	@Test
	public void testReverseSort() {
		List<Integer> arr= Arrays.asList(-1,2,1,3,4,5);
		List<Integer> expected= Arrays.asList(5,4,3,2,1,-1);
		Collections.sort(arr, new ReverseSort());
		assertEquals(expected, arr);
		
	}
}

class ReverseSort implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1; 
		// return -ve --> o1 is sorted before o2
		// return +ve --> o2 is sorted before o1
		// return 0 --> Values are same. No sorting 
	}                     
}

