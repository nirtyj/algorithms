package com.leetcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShoppingOffersTest {

	@Test
	public void test() {
		List<Integer> prices = Arrays.asList(2,5);
		List<List<Integer>> special = Arrays.asList(Arrays.asList(3,0,5), Arrays.asList(1,2,10));
		List<Integer> needs = Arrays.asList(3,2);
		ShoppingOffers offer = new ShoppingOffers();
		int price = offer.shoppingOffers(prices, special, needs);
		assertEquals(14, price);
	}

}
