package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GroupAnagramsTest {

	@Test
	public void test() {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result =GroupAnagrams.groupAnagrams(input);
		assertEquals(3, result.size());
	}

}
