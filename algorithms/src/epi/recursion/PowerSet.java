package epi.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ps = new ArrayList<>();
		ps.add(new ArrayList<Integer>()); // add the empty set

		// for every item in the original list

		for (int i = 0; i < nums.length; i++) {
			Integer item = nums[i];
			List<List<Integer>> newPs = new ArrayList<List<Integer>>();

			for (List<Integer> subset : ps) {
				// copy all of the current powerset's subsets
				newPs.add(subset);

				// plus the subsets appended with the current item
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			ps = newPs;
		}
		return ps;
	}

	private static final double LOG_2 = Math.log(2);

	public static List<List<Integer>> powerSet2n(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < (1 << A.size()); i++) {
			int bits = i;
			ArrayList<Integer> ints = new ArrayList<>();
			while (bits != 0) {
				// bits & ~(bits-1) finds the least set bit
				// then try to find the which bit position that is set by
				// lets say lsb = 4, 100 
				// then 2^x = 4 . x = 2 i.e needs to be 2nd position
				// hence 2^x = 4, => log 2(4) => Math.log(4) / Math.log(2)
				int bitposition = (int) (Math.log(bits & ~(bits - 1)) / LOG_2);
				ints.add(A.get(bitposition));
				bits = bits & (bits - 1);
			}
			result.add(ints);
		}
		return result;
	}
	
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
	    Set<Set<T>> sets = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<T>());
	    	return sets;
	    }
	    List<T> list = new ArrayList<T>(originalSet);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    for (Set<T> set : powerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }		
	    return sets;
	}
	
	public static <T> List<List<T>> powerset(Collection<T> list) {
		  List<List<T>> ps = new ArrayList<List<T>>();
		  ps.add(new ArrayList<T>());   // add the empty set
		 
		  // for every item in the original list
		  for (T item : list) {
		    List<List<T>> newPs = new ArrayList<List<T>>();
		 
		    for (List<T> subset : ps) {
		      // copy all of the current powerset's subsets
		      newPs.add(subset);
		 
		      // plus the subsets appended with the current item
		      List<T> newSubset = new ArrayList<T>(subset);
		      newSubset.add(item);
		      newPs.add(newSubset);
		    }
		 
		    // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
		    ps = newPs;
		  }
		  return ps;
		}

	/**
	 * https://prismoskills.appspot.com/lessons/Dynamic_Programming/Chapter_16_-_Powerset.jsp
	 */
	
	/**
	 * http://javabypatel.blogspot.com/2015/10/all-subsets-of-set-powerset.html
	 */
	
	/**
	 * http://stackoverflow.com/questions/29478920/java-finding-all-subsets-of-a-string-powerset-recursively
	 * @param s
	 * @return
	 */
	static List<String> powerSet(String s) {
	    // the number of subsets is 2^n
	    long numSubsets = 1L << s.length();
	    return powerSet(s, numSubsets - 1);
	}

	static List<String> powerSet(String s, long active) {
	    if (active < 0) {
	        // Recursion base case
	        // All 2^n subsets were visited, stop here and return a new list
	        return new ArrayList<>();
	    }

	    StringBuilder subset = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        // For each bit
	        if (isSet(active, i)) {
	            // If the bit is set, add the correspondent char to this subset
	            subset.append(s.charAt(i));
	        }
	    }
	    // Make the recursive call, decrementing active to the next state,
	    // and get the returning list
	    List<String> subsets = powerSet(s, active - 1);
	    // Add this subset to the list of subsets
	    subsets.add(subset.toString());
	    return subsets;
	}

	static boolean isSet(long bits, int i) {
	    // return true if the ith bit is set
	    return (bits & (1L << i)) != 0;
	}
}
