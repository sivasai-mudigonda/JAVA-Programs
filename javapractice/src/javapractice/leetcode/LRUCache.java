/**
 * 
 * Leet Code Ques = https://leetcode.com/problems/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 {capacity}  );

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
 * Time Complexity for put and get is O(1). This is because of put and get functions of hashmap.
 * Space Complexity = O(n). This is because of Double linked list.
 * 
 * Refer "https://www.youtube.com/watch?v=S6IfqDXWa10" {For Concept}
 * Refer "https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache.java" {For Code}
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

class DNode{
	int key;
	int value;
	DNode prev;
	DNode next;
}


class LRUCacheUtil{
	int totalElementsInCache;
	int totalCapacity;
	DNode head,tail;
	Map<Integer,DNode> lruMap= new HashMap<>();
	
	LRUCacheUtil(int capacity){
		totalCapacity=capacity;
		head= new DNode();
		head.prev=null;
		
		tail= new DNode();
		tail.next=null;
		
		head.next=tail;
		tail.prev=head;
	}
	
	public int get(int key) {
		DNode node=lruMap.get(key);
		if(node==null) {
			return -1;
		} else {
			// Mode the node to the front
			removeNode(node);
			InsertNode(node);
		}
		return node.value;
	}
	
	private void InsertNode(DNode node) {
		// Insert from left{Queue}
		node.prev=head; // point to dummy head
		node.next=head.next; // Point to next item from the current head
		
		head.next.prev=node; // current heads, next item's, prev need to point to node.
		
		head.next=node; // Dummy Head next should point to node.
		totalElementsInCache++;
		
	}
	
	private void removeNode(DNode node) {
		DNode prevNode= node.prev;
		DNode nextNode= node.next;
		
		prevNode.next=nextNode;
		nextNode.prev=prevNode;
		totalElementsInCache--;
	}
	
	public void put(int key, int value) {
		DNode node=lruMap.get(key);
		if(node==null) {
			// Insert new node
			if(totalElementsInCache>=totalCapacity ) {
				// Eviction Policy
				removeFromTail();				
			}
			node = new DNode();
			node.key=key;
			node.value=value;
		} else {
			// Update value
			removeNode(node);
			node.value=value;			
		}
		InsertNode(node);
		lruMap.put(key, node);
	}
	
	private void removeFromTail() {
		DNode node=tail.prev; // Dummy tail
		removeNode(node);
		lruMap.remove(node.key);
	}
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache{
	public static void main(String[] str) {
		LRUCacheUtil lru= new LRUCacheUtil(5); // 5 here is the capacity
		lru.put(11,24); // Insert
		lru.put(12,36); // Insert
		int res = lru.get(11); // 11 key should come to front.
		System.out.println("result = "+res);
		lru.put(13,87); // Insert
		lru.put(14,111); // Insert
		lru.put(15,765); // Insert
		lru.put(16,999); // Crossed existing capacity, should remove from tail{11} and insert new node{16} in front
		lru.put(12,56); // Update Existing key's value and bring it to front
		res = lru.get(11); // Key not found {-1}
		System.out.println("result = "+res);
		res = lru.get(16); // Output 999
		System.out.println("result = "+res);
		
	}
}