/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 127 {Word Ladder}
 * https://leetcode.com/problems/word-ladder/
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
	Example 1:
	
	Input:
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]
	
	Output: 5
	
	Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	Example 2:
	
	Input:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	
	Output: 0
	
	Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 *
 * For solution, refer https://www.youtube.com/watch?v=PeyYhb8lJJU
 * 
 * Time Complexity = O(l*N)
 * where l = length of String{characters} and N is number of words
 * 
 * Space Complexity = O(N) - Number of words stored in dictionary
 */
public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		
		String[] strArr1 = {"hot","dot","dog","lot","log","cog"};
		String beginWord1 = "hit";
		String endWord1 = "cog";
		List<String> wordList1 = Arrays.asList(strArr1); // Arrays.asList gives unmodifiable{add/remove cannot be performed} List.
		System.out.println("Length of shortest transformation sequence from beginWord to endWord = "
				            +wordLadder.ladderLength(beginWord1,endWord1,wordList1) ); // Expected Output = 5
		
		String[] strArr2 = {"hot","dot","dog","lot","log"};
		String beginWord2 = "hit";
		String endWord2 = "cog";
		List<String> wordList2 = Arrays.asList(strArr2);
		System.out.println("Length of shortest transformation sequence from beginWord to endWord = "
				            +wordLadder.ladderLength(beginWord2,endWord2,wordList2) ); // Expected Output = 0
	}
	
	private int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// Finding an element by value in a HashSet is O(1). In an ArrayList, it's O(n).
		// So, we choose HashSet
		Set<String> wordSet = new HashSet<>(wordList);
		if(!wordSet.contains(endWord) ){
			return 0;
		}
        
		Queue<String> queue = new LinkedList<>();
		int res=0;
		queue.offer(beginWord);
		while(!queue.isEmpty() ){ // BFS- Shortest
			for(int k=queue.size();k>0;k--) {
				String word = queue.poll();
				if(word.equals(endWord) ){
					return res+1; // Reached endWord
				}
				for(int i=0;i<word.length();i++) {
					char[] charArr= word.toCharArray(); // Reset word
					for(char ch='a';ch<='z';ch++) {
						// replace character in the "word "to build "newWord"
						// Check if it is present in the dictionary
						charArr[i] = ch;
						String newWord = new String(charArr);
						if(wordSet.contains(newWord) && !newWord.equals(word) ){
							// newWord is present in the dictionary and not equals to existing word
							queue.offer(newWord);
							wordSet.remove(newWord);
						}
					}
				}
			}
			res++;
		}
		return 0; // transformation sequence not found
    }
}
