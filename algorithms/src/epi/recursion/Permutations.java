package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * Permutations on a list
	 * @param A
	 * @return
	 */
	public static List<List<Integer>> permutations(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();
		recurseHelper(A, 0, result);
		return result;

	}

	private static void recurseHelper(List<Integer> inputList, int i, List<List<Integer>> outputList) {
		if (i == inputList.size() - 1) {
			outputList.add(new ArrayList<Integer>(inputList));
			return;
		}

		for (int j = i; j < inputList.size(); j++) {
			swap(inputList, i, j);
			recurseHelper(inputList, i + 1, outputList);
			swap(inputList, j, i);
		}
	}

	private static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	/**
	 * Permuations on a string
	 * @param s
	 * @return
	 */
	public static List<String> permString(String s) {
		List<String> result = new ArrayList<String>();
		perm1("", s, result);
		return result;
	}

	private static void perm1(String prefix, String string, List<String> result) {

		if (string.equals("")) {
			result.add(prefix);
		} else {
			for (int i = 0; i <= string.length() - 1; i++) {
				perm1(prefix + string.charAt(i), string.substring(0, i) + string.substring(i + 1, string.length()), result);
			}
		}
	}
	
	public static List<ArrayList<Integer>> permutationsIterative(List<Integer> A) {
		List<ArrayList<Integer>> result = new ArrayList<>();
		 
		//start from an empty size list
		result.add(new ArrayList<Integer>());
		
		for(int i=0;i<A.size(); i++)
		{
			//calculate and store current permuations
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			// go through result permuations and insert I from 0 to size index.
			for (ArrayList<Integer> perm : result) {
				
				// # of locations to insert is largest index + 1
				for (int j = 0; j < perm.size()+1; j++) {
					
					// + add num[i] to different locations
					perm.add(j, A.get(i));
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(perm);
					current.add(temp);
	 
					System.out.println(temp);
	 
					// - remove num[i] add
					perm.remove(j);
				}
			}
	 
			// assign current permuations as the next input for next or result
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		
		return result;
	 
	}
}
