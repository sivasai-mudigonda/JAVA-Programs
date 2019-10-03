/**
 * 
 */
package linklist;

import java. util. Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author SivaM
 * 
 * LeetCode Ques - 146 {LRU Cache}
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
	Example:
	
	LRUCache cache = new LRUCache( 2); // capacity
	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4

 * 
 * Time Complexity = O(1)
 * Space Complexity = o(N) where N is the elements in the map
 */
public class LRUCache {

	/**
	 * @param args
	 */
	
	Map<Integer,Integer> map;
	Integer capacity;
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2); /* capacity */
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // Expected returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // Expected returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // Expected returns -1 (not found)
		System.out.println(cache.get(3));       // Expected returns 3
		System.out.println(cache.get(4));       // Expected returns 4
	}
	
	/**
	 * 
	 * @param capacity
	 */
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    
	/**
	 * 
	 * @param key
	 * @return
	 * 
	 *  if key not present, return -1
	 *  if key is present, remove and insert key-{Exact steps which we do in put method}
	 *  Finally return value.
	 */
    public int get(int key) {
    	Integer value = map.compute(key, (k, v) ->
                                    v==null?-1: v
                                   );
        if(value==null) {
        	return -1;
        } else {
        	put(key,value);
        }
        return value;
    }
    
    /**
     * 
     * @param key
     * @param value
     * 
     * if key is present, remove and insert key
     * if key is not present, check if capacity is full or not.
     *    if capacity is full, remove left most value{Zero index in map} and insert new value
     *    if there is capacity, simply insert key,value to map.
     */
    public void put(int key, int value) {
        if(map.containsKey(key) ){
        	map.remove(key);
        } else if(map.size() >= capacity) {
        	Iterator<Integer> it = map.keySet().iterator();
        	it.next();
        	it.remove();
        }
        map.put(key,value);
    } 
}
