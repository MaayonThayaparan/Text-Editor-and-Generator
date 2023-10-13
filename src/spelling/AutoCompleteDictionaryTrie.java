package spelling;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author Maayon Thayaparan
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Inserts a word into the trie.
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie. It should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{

		TrieNode currNode = root;
		char[] letters = word.toLowerCase().toCharArray(); 
		
		for (int i=0; i<letters.length; i++) {
			
			char c = letters[i]; 
			
			if (currNode.getChild(c) == null ) {
				currNode = currNode.insert(c);
			}
			else {
				currNode = currNode.getChild(c);
			}
		}
		
		if (currNode.endsWord() == true) {
			return false; 
		}
		
		currNode.setEndsWord(true);
		size +=1; 
		
	    return true;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
			
		TrieNode currNode = root;
		char[] letters = s.toLowerCase().toCharArray(); 
		
		for (int i=0; i<letters.length; i++) {
			
			char c = letters[i]; 
			
			if (currNode.getChild(c) == null ) {
				return false; 
			}
			else {
				currNode = currNode.getChild(c);
			}
		}
		
		if (currNode.endsWord()) {
			return true; 
		}
		
		return false;
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // This method does the following:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
  		TrieNode currNode = root;
  		char[] letters = prefix.toLowerCase().toCharArray();
 		LinkedList<TrieNode> q = new LinkedList<TrieNode>(); 
 		LinkedList<String> completions = new LinkedList<String>(); 
    	 
    	 if (numCompletions <= 0) {
    		 return completions; 
    	 }
    	 
		for (int i=0; i<letters.length; i++) {
			
			char c = letters[i]; 
			
			if (currNode.getChild(c) == null ) {
				return completions; 
			}
			else {
				currNode = currNode.getChild(c);
			}
		}
		q.add(currNode);

		
		
		while (!q.isEmpty() && completions.size() < numCompletions) {
			
			currNode = q.removeFirst(); 
			if (currNode.endsWord()) {
				completions.addLast(currNode.getText());
			}
			
			Set<Character> currSet = currNode.getValidNextCharacters(); 
			for (char c: currSet) {
				q.addLast(currNode.getChild(c));
			}
		}
         return completions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
		
 		String currWord = String.valueOf(curr.endsWord());
 		System.out.println(curr.getText() + " " + currWord);
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}