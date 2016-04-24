package epi.arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApplyPermutations {

	/**
	 * 
	 * Move it based on Permuations array.
	 * @param permuation
	 * @param array
	 */
	public static void applyPermutationsWithNegative(List<Integer> permuation, List<Character> array) 
	{
		for (int i = 0; i < permuation.size(); i++) {
			// get next location
			int location = permuation.get(i);

			// get char to put
			Character putChar = array.get(i);

			// check if the location is not negative
			while (location >= 0) {
				//copy next char to copy
				Character next = array.get(location);

				// update the array
				array.set(location, putChar);

				// copy next location to move
				int newLocation = permuation.get(location);

				// update the permuation location to negative
				permuation.set(location, permuation.get(location) - permuation.size());

				// update the next char and next location
				location = newLocation;
				putChar = next;
			}
		}

		// restore the permuation
		for (int i = 0; i < permuation.size(); i++)
			permuation.set(i, permuation.get(i) + permuation.size());
	}

	/**
	 * same as above but with hashset
	 * @param permuation
	 * @param array
	 */
	public static void applyPermutationsWithHashSet(List<Integer> permuation, List<Character> array) {
		Set<Integer> locationsMoved = new HashSet<Integer>();
		for (int i = 0; i < permuation.size(); i++) {
			int location = permuation.get(i);
			Character putChar = array.get(i);
			while (!locationsMoved.contains(location)) {
				locationsMoved.add(location);
				Character next = array.get(location);
				array.set(location, putChar);
				location = permuation.get(location);
				putChar = next;
			}
		}
	}
	
	public static void applyPermutations(List<Integer> permuation, List<Character> array) {
		for (int i = 0; i < array.size(); i++) {
			int next = i;
			while (permuation.get(next) >= 0) {
				Collections.swap(array, i, permuation.get(next));
				int temp = permuation.get(next);
				permuation.set(next, permuation.get(next) - permuation.size());
				next = temp;
			}
		}

		for (int i = 0; i < permuation.size(); i++)
			permuation.set(i, permuation.get(i) + permuation.size());
	}
}
