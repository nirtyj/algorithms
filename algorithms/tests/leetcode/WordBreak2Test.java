package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordBreak2Test {

	@Test
	public void test() {
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		assertNotNull(WordBreak2.wordBreak("leetcode", dict));
	}
	

	@Test
	public void test2() {
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		assertNotNull(WordBreak2.wordBreak("catsanddog", dict));
	}
	
	@Test
	public void test3() {
		List<String> dict = new ArrayList<String>();
		dict.add("b");
		assertNotNull(WordBreak2.wordBreak("a", dict));
	}
}

