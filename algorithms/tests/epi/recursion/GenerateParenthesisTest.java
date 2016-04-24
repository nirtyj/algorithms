package epi.recursion;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class GenerateParenthesisTest {

	@Test
	public void test() {
		List<String> result = GenerateParenthesis.generateBalancedParentheses(1);
		assertTrue(result.size() == 1 && result.get(0).equals("()"));
		result = GenerateParenthesis.generateBalancedParentheses(2);
		assertTrue(result.size() == 2 && ((result.get(0).equals("(())") && result.get(1).equals("()()"))
				|| (result.get(0).equals("()()") && result.get(1).equals("(())"))));
	}

}
