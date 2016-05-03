package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

	@Test
	public void test() {
		String[] input = {"interspecies", "interstellar","interstate"};
		assertEquals("inters", LongestCommonPrefix.longestCommonPrefix(input));
	}
	
	@Test
	public void test2() {
		String[] input = {"throne", "throne"};
		assertEquals("throne", LongestCommonPrefix.longestCommonPrefix(input));
	}
	
	@Test
	public void test3() {
		String[] input = {"throne", "dungeon"};
		assertEquals("", LongestCommonPrefix.longestCommonPrefix(input));
	}
	
	@Test
	public void test4() {
		String[] input = {"cheese"};
		assertEquals("cheese", LongestCommonPrefix.longestCommonPrefix(input));
	}
	
	@Test
	public void test5() {
		String[] input = {"foo", "fooar"};
		assertEquals("foo", LongestCommonPrefix.longestCommonPrefix(input));
	}
	

}
