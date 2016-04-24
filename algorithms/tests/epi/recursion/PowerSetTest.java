package epi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PowerSetTest {

	@Test
	public void test() {
		List<Integer> EMPTY_LIST = new ArrayList<>();

	    List<Integer> input = Arrays.asList(0, 1, 2);
	    List<List<Integer>> goldenResult = Arrays.asList(
	        EMPTY_LIST, Arrays.asList(0), Arrays.asList(1), Arrays.asList(0, 1),
	        Arrays.asList(2), Arrays.asList(0, 2), Arrays.asList(1, 2),
	        Arrays.asList(0, 1, 2));

	    check(input, goldenResult);
	}
	private static void check(List<Integer> input, List<List<Integer>> expected) {
	    List<List<Integer>> got = PowerSet.powerSet2n(input);
	    Set<Set<Integer>> gotSet = new HashSet<>();
	    for (List<Integer> item : got) {
	      gotSet.add(new HashSet<>(item));
	    }
	    if (gotSet.size() != got.size()) {
	      System.err.println("Error, your powerset has duplicate entries.");
	      System.err.println("Input:" + input);
	      System.err.println("Your result:" + got);
	      System.exit(-1);
	    }

	    Set<Set<Integer>> expectedSet = new HashSet<>();
	    for (List<Integer> item : expected) {
	      expectedSet.add(new HashSet<>(item));
	    }

	    if (!expectedSet.equals(gotSet)) {
	      System.err.println("Error on input " + input);
	      System.err.println("Expected " + expected);
	      System.err.println("Got " + got);
	      System.exit(-1);
	    }
	  }
}
