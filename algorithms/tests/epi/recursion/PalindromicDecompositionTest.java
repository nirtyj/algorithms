package epi.recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PalindromicDecompositionTest {

	@Test
	public void test() {
		List<List<String>> result = PalindromicDecomposition.palindromePartitioning("abbbac");
	    List<List<String>> golden = Arrays.asList(
	        Arrays.asList("a", "b", "b", "b", "a", "c"),
	        Arrays.asList("a", "b", "bb", "a", "c"),
	        Arrays.asList("a", "bb", "b", "a", "c"),
	        Arrays.asList("a", "bbb", "a", "c"), Arrays.asList("abbba", "c"));
	    System.out.println(result);
	    assertTrue(result.equals(golden));
	}

}
