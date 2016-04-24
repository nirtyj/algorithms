package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static List<String> generateBalancedParentheses(int numPairs) {
		List<String> result = new ArrayList<>();
		directedGenerateBalancedParentheses("", numPairs, numPairs, result);
		return result;
	}

	private static void directedGenerateBalancedParentheses(String inputString, int numLeftParensNeeded,
			int numRightParensNeeded, List<String> result) {
		if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
			result.add(inputString);
			return;
		}

		// Able to insert '('.  and shound be finishable by )
		if (numLeftParensNeeded >= 1 && numRightParensNeeded >= 1) { 
			directedGenerateBalancedParentheses(inputString + "(", numLeftParensNeeded - 1, numRightParensNeeded,
					result);
		}
		
		// Trim the tree that starts with )
		if (numLeftParensNeeded < numRightParensNeeded) {
			directedGenerateBalancedParentheses(inputString + ")", numLeftParensNeeded, numRightParensNeeded - 1,
					result);
		}
	}
}
