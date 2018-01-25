package epi.trie;

import java.util.HashMap;

/**
 * Leetcode verified
 * 
 * @author njaganathan
 */
public class PrefixTree {
	TrieNode root;

	/** Initialize your data structure here. */
	public PrefixTree() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = children.get(c);
			if (node == null) {
				TrieNode n = new TrieNode();
				children.put(c, n);
				node = n;
			}
			node.c = c;
			if (i == word.length() - 1)
				node.isEndWord = true;
			else
				children = node.children;
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode t = find(root, word, 0);
		if (t != null && t.isEndWord)
			return true;
		else
			return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode t = find(root, prefix, 0);
		if (t != null)
			return true;
		else
			return false;
	}

	public TrieNode find(TrieNode node, String word, int index) {
		if (index >= word.length() || node == null)
			return node;
		char desiredC = word.charAt(index);
		TrieNode n = node.children.get(desiredC);
		if (n == null) {
			return null;
		} else {
			return find(n, word, index + 1);
		}
	}
}
