package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author Maayon Thayaparan
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		if (wordList.size() <= 0) {
			String[] source = sourceText.split(" +"); 
			starter = source[0]; 
			String prevWord = starter;
			
			for (int w=1; w<source.length; w++) {
				prevWord = this.addWords(prevWord,source[w]);
			}
			this.addWords(prevWord, starter);
		}

	}
	
	private String addWords(String prevWord, String currWord) {
		
		boolean prevWordExists = false; 
		for (ListNode n : wordList) {
			
			if (n.getWord().equals(prevWord)) {
				prevWordExists = true;
				break;
			}
		}
		
		if (prevWordExists) {
			for (ListNode n : wordList) {
				if (n.getWord().equals(prevWord)) {
					n.addNextWord(currWord);;
					break;
				}
			} 
		}
		else {
			ListNode newNode = new ListNode(prevWord);
			newNode.addNextWord(currWord);
			wordList.add(newNode);
		}
		prevWord = currWord;
		return prevWord; 
	}
	

	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		
		if (wordList.size() <= 0) {
			return "";
		}
		
		if (numWords <= 0) {
			return ""; 
		}
		
		StringBuilder output = new StringBuilder();
		String currWord = starter;
		output.append(starter);
		int count = 1; 
		while (count < numWords) {
			for (ListNode n : wordList) {
				if (n.getWord().equals(currWord)) {
					String ranWord = n.getRandomNextWord(rnGenerator);
					output.append(" " + ranWord);
					currWord = ranWord;
					count +=1; 
					break;
				}
			}
			
		}	
		return output.toString();
	}
	
	
	// Helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		this.train(sourceText);
	}
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));		
		//String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		String textString = "\n** Test 1: Generating text before training...";
		System.out.println(textString);
		//gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
		/*
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		*/
		
	}

}

/** Class is used to link a word to the next words in the list 
*/
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
	    // The random number generator is passed from 
	    // the MarkovTextGeneratorLoL class

		int rand = generator.nextInt(nextWords.size()); 
		String ranWord = nextWords.get(rand);
		
	    return ranWord;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


