package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import dynamic_programming.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

	@Test
	public void test() {
		//assertEquals("AC", LongestCommonSubsequence.getLongestCommonSubsequenceRecursive("AC", "ACN"));
		assertEquals("ADH", LongestCommonSubsequence.getLongestCommonSubsequenceRecursive("ABCDGH", "AEDFHR"));
		assertEquals("GTAB", LongestCommonSubsequence.getLongestCommonSubsequenceRecursive("AGGTAB", "GXTXAYB"));	
		//assertEquals("ACCTAGTATTGTTC", LongestCommonSubsequence.getLongestCommonSubsequenceRecursive("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC"));
	}
	
	@Test
	public void testMemoization() {
		//assertEquals("AC", LongestCommonSubsequence.getLongestCommonSubsequenceMemoization("AC", "ACN"));
		assertEquals("ADH", LongestCommonSubsequence.getLongestCommonSubsequenceMemoization("ABCDGH", "AEDFHR"));
		assertEquals("GTAB", LongestCommonSubsequence.getLongestCommonSubsequenceMemoization("AGGTAB", "GXTXAYB"));	
		//assertEquals("ACCTAGTATTGTTC", LongestCommonSubsequence.getLongestCommonSubsequenceMemoization("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC"));
	}
	
	@Test
	public void testLCS() {
		assertEquals("AC", LongestCommonSubsequence.getLongestCommonSubsequence("AC", "ACN"));
		assertEquals("ADH", LongestCommonSubsequence.getLongestCommonSubsequence("ABCDGH", "AEDFHR"));
		assertEquals("GTAB", LongestCommonSubsequence.getLongestCommonSubsequence("AGGTAB", "GXTXAYB"));	
		assertEquals("ACCTAGTATTGTTC", LongestCommonSubsequence.getLongestCommonSubsequence("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC"));
	}

}
