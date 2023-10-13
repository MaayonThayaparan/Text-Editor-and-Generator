package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;

	
	public DictionaryLL() {
		dict = new LinkedList<String>(); 
	}


    /** Add this word to the dictionary.  Convert it to lower case first.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
	
    public boolean addWord(String word) {
    
    	word = word.toLowerCase();
    	
    	for (int i=0; i<dict.size(); i++) {
    		if (dict.get(i).equals(word)) {
    			return false;
    		}
    	}
    	
    	dict.add(word); 

        return true;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {

        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {

    	s = s.toLowerCase();
    	
    	for (int i=0; i<dict.size(); i++) {
    		if (dict.get(i).equals(s)) {
    			return true; 
    		}
    	}
    	
        return false;
    }

    
}
