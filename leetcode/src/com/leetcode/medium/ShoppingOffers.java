package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.

Note:
There are at most 6 kinds of items, 100 special offers.
For each item, you need to buy at most 6 of them.
You are not allowed to buy more items than you want, even if that would lower the overall price
*/
public class ShoppingOffers {

	int minPrice = Integer.MAX_VALUE;

	/**
	 * Leetcode verified
	 * @param price
	 * @param special
	 * @param needs
	 * @return
	 */
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		recurseHelper(0, price, special, needs);
		return minPrice;
	}

	public void recurseHelper(int currentPrice, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		if (currentPrice >= minPrice)
			return;

		minPrice = Math.min(minPrice, currentPrice + calculateIndividualPrices(needs, price));

		for (int i = 0; i < special.size(); i++) {
			ArrayList<Integer> newNeeds = new ArrayList<Integer>(needs);
			List<Integer> specialEntry = special.get(i);
			boolean isOk = true;
			for (int j = 0; j < newNeeds.size(); j++) {
				newNeeds.set(j, newNeeds.get(j) - specialEntry.get(j));
				if (newNeeds.get(j) < 0) {
					isOk = false;
					break;
				}
			}

			if (isOk) {
				recurseHelper(currentPrice + specialEntry.get(specialEntry.size() - 1), price, special, newNeeds);
			}
		}
	}

	private int calculateIndividualPrices(List<Integer> needs, List<Integer> price) {
		int val = 0;
		for (int i = 0; i < needs.size(); i++) {
			val = val + needs.get(i) * price.get(i);
		}
		return val;
	}
	
	/**
	 * Leetcode verified - with memoization
	 * @param price
	 * @param special
	 * @param needs
	 * @return
	 */
	public int shoppingOffers2(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return recurseHelper2(price, special, needs, new HashMap<List<Integer>, Integer>());
	}

	public int recurseHelper2(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map < List < Integer > , Integer > map) {
		if(map.containsKey(needs))
			return map.get(needs);
		int result = calculateIndividualPrices(needs, price);
		for (int i = 0; i < special.size(); i++) {
			ArrayList<Integer> newNeeds = new ArrayList<Integer>(needs);
			List<Integer> specialEntry = special.get(i);
			boolean isOk = true;
			for (int j = 0; j < newNeeds.size(); j++) {
				newNeeds.set(j, newNeeds.get(j) - specialEntry.get(j));
				if (newNeeds.get(j) < 0) {
					isOk = false;
					break;
				}
			}

			if (isOk) {
				result = Math.min(result, specialEntry.get(specialEntry.size() - 1) + recurseHelper2(price, special, newNeeds, map));
			}
		}
		map.put(needs, result);
		return result;
	}
}
