package epi.recursion;

import java.util.ArrayList;
import java.util.List;

import epi.strings.StringPalidrome;

public class PalindromicDecomposition {

	public static List<List<String>> palindromePartitioning(String input) {
		List<List<String>> result = new ArrayList<>();
		palindromePartitioningHelper(input, 0, new ArrayList<String>(), result);
		return result;
	}

	private static void palindromePartitioningHelper(String input, int offset, ArrayList<String> partialDecomposition,
			List<List<String>> result) {
		if (offset == input.length()) {
			result.add(new ArrayList<String>(partialDecomposition));
			return;
		}

		for (int i = offset + 1; i <= input.length(); i++) {
			String subString = input.substring(offset, i);
			if (!subString.equals("") && StringPalidrome.isPalindrome(subString)) {
				
				partialDecomposition.add(subString);
				palindromePartitioningHelper(input, i, partialDecomposition, result);
				partialDecomposition.remove(partialDecomposition.size() - 1);	
				
				// add and remove the latest added or
				// create a new arraylist for each tree going into to recursion
				// ArrayList<String> temp = new ArrayList<String> (partialDecomposition);
				// temp.add(subString);
				// use temp for the rest of the tree
			
			}
		}
	}
}
