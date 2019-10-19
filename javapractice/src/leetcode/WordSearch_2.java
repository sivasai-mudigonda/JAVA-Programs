/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SIVA SAI
 *
 * Leet Code : 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.
 *
	Example:
	Input: 
	words = ["oath","pea","eat","rain"] and board =
	[
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	
	Output: ["eat","oath"]
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * For solution, refer https://www.youtube.com/watch?v=5Ha1nJ5rjrE
 * 
 */

public class WordSearch_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char board[][]= {
							{'o','a','a','n'},
							{'k','t','a','e'},
							{'i','h','k','r'},
							{'i','f','l','v'}
						};
		String[] words = {"oath","pea","eat","rain"};
		List<String> res = findWords(board,words);
		res.forEach(System.out::println); // Expected output = {"eat","oath"}
	}
	
	private static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
        if(board==null || board.length==0) {
        	return res;
        }
        TrieNode root = new TrieNode();
        buildTrie(root,words); // Build Trie 
        
        for(int row=0;row<board.length;row++) {
        	for(int col=0;col<board[row].length;col++) {
        		char c= board[row][col];
        		if(root.dictonary.get(c)!=null ){        			
        			dfs(board, row, col, root, res); // DFS
        		}
        	}
        }
        
        return res;
    }
	
	private static void dfs(char[][] board, int row, int col,TrieNode curr,List<String> res) {
		if(row<0 ||  col<0 || row > board.length-1 || col > board[row].length-1) {
			return;
		}
		
		// Is character Visited already. If we dont use below way, We need to come up with Two Dimensional boolean matrix.
		if(board[row][col]=='#') {
			return;
		}
		char c= board[row][col];		
		TrieNode node = curr.dictonary.get(c);
		if(node==null) {
			return;
		}
		if(node.word!=null && !node.word.isEmpty()) {
			res.add(node.word);
			node.word=null;
		}
		board[row][col] ='#'; // Mark as visited
		dfs(board,row+1,col,node,res);
		dfs(board,row-1,col,node,res);
		dfs(board,row,col+1,node,res);
		dfs(board,row,col-1,node,res);
		board[row][col] = c; // Replace back character. Backtracking
	}
	
	private static void buildTrie(TrieNode root, String[] words) {
		for(String word: words) {
			TrieNode curr = root; // For every word, start from the root.
			for(char c: word.toCharArray()) {
				TrieNode node = curr.dictonary.get(c);
				if(node==null ){
					node = new TrieNode();
					curr.dictonary.put(c, node);
				}
				curr = node;
			}
			curr.word = word;
		}
	}
	
	private static class TrieNode{
		String word;
		Map<Character,TrieNode> dictonary;
		
		TrieNode(){
			word="";
			dictonary = new HashMap<>();
		}
	}
}
