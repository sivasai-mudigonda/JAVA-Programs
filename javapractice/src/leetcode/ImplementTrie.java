/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SIVA SAI
 * 
 * LeetCode Ques : 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
	Example:
	Trie trie = new Trie();
	trie.insert("apple");
	trie.search("apple");   // returns true
	trie.search("app");     // returns false
	trie.startsWith("app"); // returns true
	trie.insert("app");   
	trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 *Solution :
 *	Refer https://www.youtube.com/watch?v=AXjmTQ8LEoI {For Video}
 *	https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java {For Code}
 */
public class ImplementTrie {

	private TrieNode root = new TrieNode();
	
	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
	public static void main(String[] args) {
		ImplementTrie trieNode = new ImplementTrie();
		trieNode.insert("apple");
		System.out.println("Is 'apple' word present = " +trieNode.search("apple"));   // returns true
		System.out.println("Is 'app' word present = "+trieNode.search("app"));     // returns false
		System.out.println("Is there a word starting with'app' = "+trieNode.startsWith("app")); // returns true
		trieNode.insert("app");   
		System.out.println("Is 'apple' word present = "+trieNode.search("app"));     // returns true
		
	}
	
	 /** Inserts a word into the trie. */
	// Time Complexity O(L*M) {L= Length of word, M= num of characters}
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
        	char c = word.charAt(i);
        	TrieNode node = current.dictonary.get(c);
        	if(node==null) {
        		node = new TrieNode();
        		current.dictonary.put(c,node);
        		
        	}
        	current = node;
        }
        current.isLeaf=true;
    }
    
    public void insertRecursively(TrieNode node, String word, int index) {
    	if(index==word.length() ) {
    		node.isLeaf=true;
    		return;
    	}
    	char ch = word.charAt(index);
    	TrieNode current =node.dictonary.get(ch);
    	if(current==null) {    		
        	current = new TrieNode();
    		current.dictonary.put(ch, current);
    	}
    	insertRecursively(current,word,index+1);
    	
    }
    
    /** Returns if the word is in the trie. 
     * Time Complexity O(L) {L= Length of word}
     * */
    public boolean search(String word) {
    	TrieNode current = root;
    	for(int i=0;i<word.length();i++) {
    		char c = word.charAt(i);
    		TrieNode node = current.dictonary.get(c);
    		if(node==null) {
    			return false;
    		} else {
    			current = node;
    		}
    	}
        return current.isLeaf;
    }
    
    public boolean searchRecursively(TrieNode node,String word,int index) {
    	if(index==word.length() ) {
    		return node.isLeaf;
    	}
    	char ch= word.charAt(index);
    	TrieNode current = node.dictonary.get(ch);
    	//if node does not exist for given char then return false
    	if(current==null ){
    		return false;
    	}
    	return searchRecursively(current,word, index+1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. 
     *  Time Complexity O(L) {L= Length of word}
     * */
    public boolean startsWith(String prefix) {
    	if(prefix==null || prefix.isEmpty() ){
        	return false;
        }
    	TrieNode current = root;
    	for(int i=0;i<prefix.length();i++) {
    		char c = prefix.charAt(i);
    		TrieNode node = current.dictonary.get(c);
    		if(node==null) {
    			return false;
    		} else {
    			current = node;
    		}
    	}
    	return true;
    }
    
    /** Returns if the word is removed from the trie. */
    public void remove(String word) {
        removeRecursevely(root,word,0);
    }
    
    /**
     * Returns true if parent should delete the mapping
     * Time Complexity O(L*M) {L= Length of word, M= num of characters}
     */
    private boolean removeRecursevely(TrieNode node,String word,int index){
    	if(index==word.length() ){
    		//when end of word is reached only delete if currrent.endOfWord is true.
    		if(!node.isLeaf) {
    			return false;
    		}
    		node.isLeaf= false;
    		//if current has no other mapping then return true
    		return node.dictonary.size()==0;
    	}
    	char c= word.charAt(index);
    	TrieNode current = node.dictonary.get(c);
    	if(current==null) {
    		return false;
    	}
    	boolean shouldNodeBeDel = removeRecursevely(current,word,index+1);
    	//if true is returned then delete the mapping of character and trienode reference from map.
    	if(shouldNodeBeDel) {
    		node.dictonary.remove(c);
    		 //return true if no mappings are left in the map.
    		return node.dictonary.size()==0;
    	}
    	return false;
    }
	
    class TrieNode{
    	boolean isLeaf;
    	Map<Character,TrieNode> dictonary;
    	
    	/** Initialize your data structure here. */
        public TrieNode() {        
            isLeaf=false;
            dictonary= new HashMap<>();
        }
    }
}
