package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubstringTest {

	@Test
	public void test() {
		assertEquals("BABC", LongestCommonSubstring.getLongestCommonSubstringNaive("ABABC", "BABCA"));		
		assertEquals("tutorial", LongestCommonSubstring.getLongestCommonSubstringNaive("tutorialhorizon", "dynamictutorialProgramming"));
		assertEquals("Site:Geeks",LongestCommonSubstring.getLongestCommonSubstringNaive("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
		assertEquals("kds",LongestCommonSubstring.getLongestCommonSubstringNaive("alsdfkjfjkdsal", "fdjskalajfkdsla"));
		assertEquals(" peter go",LongestCommonSubstring.getLongestCommonSubstringNaive("Please, peter go swimming!", "I’m peter goliswi"));
	}

	@Test
	public void test2() {
		assertEquals("BABC", LongestCommonSubstring.getLongestCommonSubstring("ABABC", "BABCA"));		
		assertEquals("tutorial", LongestCommonSubstring.getLongestCommonSubstring("tutorialhorizon", "dynamictutorialProgramming"));
		assertEquals("Site:Geeks",LongestCommonSubstring.getLongestCommonSubstring("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
		assertEquals("kds",LongestCommonSubstring.getLongestCommonSubstring("alsdfkjfjkdsal", "fdjskalajfkdsla"));
		assertEquals(" peter go",LongestCommonSubstring.getLongestCommonSubstring("Please, peter go swimming!", "I’m peter goliswi"));
	}

}
