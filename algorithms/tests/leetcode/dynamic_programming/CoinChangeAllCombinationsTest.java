package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeAllCombinationsTest {

	@Test
	public void test() {
		int[] coins = { 1, 2, 3 };
		assertEquals(4, CoinChangeAllCombinations.coinChange(coins, 4));
	}

	@Test
	public void test2() {
		int[] coins = { 2, 5, 3, 6 };
		assertEquals(5, CoinChangeAllCombinations.coinChange(coins, 10));
	}

	@Test
	public void test3() {
		int[] coins = { 1, 5, 10, 25 };
		assertEquals(31, CoinChangeAllCombinations.coinChange(coins, 40));
	}

	@Test
	public void test4() {
		int[] coins = { 1, 2, 3 };
		assertEquals(4, CoinChangeAllCombinations.coinChangeDp(coins, 4));
	}

	@Test
	public void test5() {
		int[] coins = { 2, 5, 3, 6 };
		assertEquals(5, CoinChangeAllCombinations.coinChangeDp(coins, 10));
	}

	@Test
	public void test6() {
		int[] coins = { 1, 5, 10, 25 };
		assertEquals(31, CoinChangeAllCombinations.coinChangeDp(coins, 40));
	}
	
	@Test
	public void test7() {
		int[] coins = { 1, 5, 10, 25 };
		assertEquals(0, CoinChangeAllCombinations.coinChange(coins, 0));
	}
}
