package leetcode.dynamic_programming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Knapsack01Test {

	@Test
	public void test() {
		int[] w = { 2, 4, 5, 7, 9 };
		int[] v = { 3, 5, 6, 8, 10 };
		assertEquals(24, Knapsack01.findKnapsackTopDown(w, v, 20));
		assertEquals(22, Knapsack01.findKnapsackTopDown(w, v, 19));
	}
	
	@Test
	public void test1() {
		int[] w = { 1, 3, 4, 5 };
		int[] v = { 1, 4, 5, 7 };
		assertEquals(9, Knapsack01.findKnapsackTopDown(w, v, 7));
	}
	
	@Test
	public void test3() {
		int[] w = { 2, 4, 5, 7, 9 };
		int[] v = { 3, 5, 6, 8, 10 };
		assertEquals(24, Knapsack01.findKnapsackBottomUp(w, v, 20));
		assertEquals(22, Knapsack01.findKnapsackBottomUp(w, v, 19));
	}
	
	@Test
	public void test4() {
		int[] w = { 1, 3, 4, 5 };
		int[] v = { 1, 4, 5, 7 };
		assertEquals(9, Knapsack01.findKnapsackBottomUp(w, v, 7));
	}
}
