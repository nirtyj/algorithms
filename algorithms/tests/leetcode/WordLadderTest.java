package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utils.TestUtils;

public class WordLadderTest {

	@Test
	public void test() {
		String[] dictArr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> dict = TestUtils.arrayToList(dictArr);
		assertEquals(5, WordLadder.ladderLength("hit", "cog", dict));
	}

	@Test
	public void test2() {
		String[] dictArr = { "hot", "dot", "dog", "lot", "log" };
		List<String> dict = TestUtils.arrayToList(dictArr);
		assertEquals(0, WordLadder.ladderLength("hit", "cog", dict));
	}
	
	@Test
	public void test3() {
		String[] dictArr = { "hot", "dog" };
		List<String> dict = TestUtils.arrayToList(dictArr);
		assertEquals(0, WordLadder.ladderLength("hot", "dog", dict));
	}
	

	@Test
	public void test4() {
		String[] dictArr = { "hot", "dog", "dot"};
		List<String> dict = TestUtils.arrayToList(dictArr);
		assertEquals(3, WordLadder.ladderLength("hot", "dog", dict));
	}
	
	@Test
	public void test5() {
		String[] dictArr = { "hot", "dot", "dog"};
		List<String> dict = TestUtils.arrayToList(dictArr);
		assertEquals(2, WordLadder.ladderLength("hot", "dot", dict));
	}
}
