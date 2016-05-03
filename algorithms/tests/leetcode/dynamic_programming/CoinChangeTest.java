package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeTest {

	@Test
	public void test() {
		int[] coins = {1, 5, 10, 25};
		assertEquals(2, CoinChange.coinChange(coins, 35));
		assertEquals(4, CoinChange.coinChange(coins, 37));
	}
	
	@Test
	public void test1() {
		int[] coins = {1, 2, 5};
		assertEquals(3, CoinChange.coinChange(coins, 11));
	}

}
