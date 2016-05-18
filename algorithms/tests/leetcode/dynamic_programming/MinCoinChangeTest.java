package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinCoinChangeTest {

	@Test
	public void test() {
		int[] coins = {1, 5, 10, 25};
		assertEquals(2, MinCoinChange.coinChange(coins, 35));
		assertEquals(4, MinCoinChange.coinChange(coins, 37));
	}
	
	@Test
	public void test1() {
		int[] coins = {1, 2, 5};
		assertEquals(3, MinCoinChange.coinChange(coins, 11));
	}
	
	@Test
	public void test2() {
		int[] coins = {1, 5, 10, 25};
		assertEquals(2, MinCoinChange.coinChangeDp(coins, 11));
		assertEquals(4, MinCoinChange.coinChangeDp(coins, 37));
	}
	
	@Test
	public void test3() {
		int[] coins = {1, 2, 5};
		assertEquals(3, MinCoinChange.coinChangeDp(coins, 11));
	}

}
