package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

/**
* @author u230107
*
* Leet-code Ques - 380 {Insert Delete GetRandom O(1)} {Medium}
* https://leetcode.com/problems/insert-delete-getrandom-o1
*
* Design a data structure that supports all following operations in average O(1) time.
* insert(val): Inserts an item val to the set if not already present.
* remove(val): Removes an item val from the set if present.
* getRandom: Returns a random element from current set of elements.
* Each element must have the same probability of being returned.
*
	Example:
	// Init an empty set.
	RandomizedSet randomSet = new RandomizedSet();
	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
	randomSet.insert(1);
	// Returns false as 2 does not exist in the set.
	randomSet.remove(2);
	// Inserts 2 to the set, returns true. Set now contains [1,2].
	randomSet.insert(2);
	// getRandom should return either 1 or 2 randomly.
	randomSet.getRandom();
	// Removes 1 from the set, returns true. Set now contains [2].
	randomSet.remove(1);
	// 2 was already in the set, so return false.
	randomSet.insert(2);
	// Since 2 is the only number in the set, getRandom always return 2.
	randomSet.getRandom();
*
* Solution:
* 1.> Use a ArrayList to store all insert val and use a hash map to store indices of all val.
* 2.> Insert-
* 2.1> Insert in to the and save its corresponding index into hash map.
* 3.> getRandom-
* 3.1> Get Random element using Random class. Use nextInt(li.size()) to get random value from list.
* 4.> Delete-
* 4.1> Swap element in the last index with "val" element index{val_index}.
* Also, update index{value of last-element{key} in map} with val_index in the map.
*
* Operation ArrayList LinkedList
* Inserting(at the last position) O(1) O(1)
* Deleting O(n) O(n)
* Indexing O(1) O(n)
*
* Time Complexity = O(1) - Constant Time
* Space Complexity = o(N) - Linear Space required to store N elements in List and Map
*
*/
@Resource(name = "RandomizedSet")
public class Insert_Delete_GetRandom_Constant_Time {

	/**
	 * @param args
	 *
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); 
	 * boolean param_1 = obj.insert(val); 
	 * boolean param_2 = obj.remove(val); 
	 * int param_3 = obj.getRandom();
	 *
	 */
	public static void main(String[] args) {
		Insert_Delete_GetRandom_Constant_Time obj = new Insert_Delete_GetRandom_Constant_Time();
		System.out.println(obj.insert(1)); // Expected Result = Returns true as 1 was inserted successfully.
		System.out.println(obj.remove(2)); // Expected Result = Returns false as 2 does not exist in the list.
		System.out.println(obj.insert(2)); // Expected Result = Inserts 2 to the set, returns true. List now contains
											// [1,2].
		System.out.println(obj.getRandom()); // Expected Result = Returns either 1 or 2 randomly.
		System.out.println(obj.remove(1)); // Expected Result = Removes 1 from the set, returns true. List now contains
											// [2].
		System.out.println(obj.insert(2)); // Expected Result = 2 was already in the list, so return false.
		System.out.println(obj.getRandom()); // Expected Result = Since 2 is the only number in the set, getRandom
												// always return 2.
		
		
		obj = new Insert_Delete_GetRandom_Constant_Time();
		obj.remove(0);
		obj.remove(0);
		obj.insert(0);
		obj.getRandom();
		obj.remove(0);
		obj.insert(0);
		//["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
		//[[],[0],[0],[0],[],[0],[0]]
	}

	Random random;
	List<Integer> li = new ArrayList<>();
	Map<Integer, Integer> map;

	/**
	 * Initialize your data structure here.
	 */
	public Insert_Delete_GetRandom_Constant_Time() {
		random = new Random();
		li = new ArrayList<>();
		map = new HashMap<>();
	}

	/**
	 *
	 * @param val
	 * @return
	 *
	 * Inserts a value to the list. Returns true if the list did not already contain the specified element.
	 *
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			li.add(val);
			map.put(val, li.size() - 1);
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param val
	 * @return
	 *
	 *  Removes a value from the List. Returns true if the set contained the specified element.
	 *
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int val_Index = map.get(val);
			
			// Update last element's index to val_Index
			map.put(li.get(li.size()-1), val_Index);
			map.remove(val);
			
			// Move last element to val_index
			Collections.swap(li, val_Index, li.size()-1);
			li.remove(li.size() - 1);
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return
	 *
	 * Get a random element from the set.
	 *
	 */
	public int getRandom() {
		int randomIndex = random.nextInt(li.size()); // nextInt bound is exclusive.
		return li.get(randomIndex);
	}
}
