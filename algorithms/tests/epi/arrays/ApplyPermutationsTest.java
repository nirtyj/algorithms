package epi.arrays;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ApplyPermutationsTest {

	@Test
	public void test() {
		Integer[] permuation = {2, 0, 1, 3};
		Character[] charArray = {'a', 'b', 'c', 'd'};
		List<Character> input = new ArrayList<Character> (Arrays.asList(charArray));
		ApplyPermutations.applyPermutations(Arrays.asList(permuation), input);
		Character[] output = {'b', 'c', 'a', 'd'};
		assertTrue(Arrays.asList(output).equals(input));
	}
	
	@Test
	public void test1() {
		Integer[] permuation = {2, 0, 1, 3};
		Character[] charArray = {'a', 'b', 'c', 'd'};
		List<Character> input = new ArrayList<Character> (Arrays.asList(charArray));
		ApplyPermutations.applyPermutationsWithNegative(Arrays.asList(permuation), input);
		Character[] output = {'b', 'c', 'a', 'd'};
		assertTrue(Arrays.asList(output).equals(input));
	}
	
	@Test
	public void test2() {
		Integer[] permuation = {3, 1, 2, 0};
		Character[] charArray = {'a', 'b', 'c', 'd'};
		List<Character> input = new ArrayList<Character> (Arrays.asList(charArray));
		ApplyPermutations.applyPermutationsWithNegative(Arrays.asList(permuation), input);
		Character[] output = {'d', 'b', 'c', 'a'};
		assertTrue(Arrays.asList(output).equals(input));
	}

}
