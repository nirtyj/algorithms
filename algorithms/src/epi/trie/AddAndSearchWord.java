package epi.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet code tested and verified
 * @author njaganat
 *
 */
public class AddAndSearchWord {

	TrieNode root = new TrieNode();

	public void addWord(String word) {
		HashMap<Character, TrieNode> map = root.children;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = map.get(word.charAt(i));
			if (node == null) {
				node = new TrieNode(word.charAt(i));
				map.put(word.charAt(i), node);
			}
			if (i == word.length() - 1)
				node.isEndWord = true;
			map = node.children;
		}
	}

	public boolean searchWord(String word) {
		return dfsSearch(root.children, word, 0);
	}

	private boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
		if (start == word.length()) 
		{
			return false;
		}

		char c = word.charAt(start);

		if (children.containsKey(c)) 
		{
			if (start == word.length() - 1 && children.get(c).isEndWord) {
				return true;
			}
			return dfsSearch(children.get(c).children, word, start + 1);
		} 
		// . represents - match any character
		else if (c == '.') 
		{
			boolean result = false;
			// at one recursion you have bunch of nodes to check if its present or if its is a end word
			for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
				
				if (start == word.length() - 1 && child.getValue().isEndWord) {
					return true;
				}

				//if any path is true, set result to be true; 
				if (dfsSearch(child.getValue().children, word, start + 1)) {
					result = true;
					break;
				}
			}

			return result;
		} 
		else 
		{
			return false;
		}
	}
}
