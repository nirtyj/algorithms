package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

	@Test
	public void test() {
		Trie t = new Trie();
		t.addWord("hell");
		t.addWord("hello");
		t.addWord("hel");

		assertTrue(t.searchWord("hello"));
		assertTrue(t.searchWord("hel"));
		assertTrue(t.searchWord("hel"));
		assertFalse(t.searchWord("he"));
		assertFalse(t.searchWord("hellob"));
		assertTrue(t.searchWord("he."));
		assertTrue(t.searchWord("h.."));
		assertTrue(t.searchWord("hell."));
		assertTrue(t.searchWord("hel.o"));
		assertTrue(t.searchWord(".el.o"));
		assertFalse(t.searchWord(".bl.o"));

		t.addWord("bad");
		t.addWord("dad");
		t.addWord("mad");

		assertFalse(t.searchWord("pad"));// -> false
		assertTrue(t.searchWord("bad"));
		assertTrue(t.searchWord(".ad"));
		assertTrue(t.searchWord("b.."));
		
		t.addWord("a");
		assertFalse(t.searchWord("a."));
	}

}
