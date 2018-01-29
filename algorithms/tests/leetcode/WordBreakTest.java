package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordBreakTest {

	@Test
	public void test() {
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		assertEquals(true, WordBreak.wordBreak("leetcode", dict));
	}

}
