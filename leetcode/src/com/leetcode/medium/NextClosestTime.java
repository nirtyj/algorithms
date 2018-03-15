package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
*/
public class NextClosestTime {

	private String givenTime;
	private String result;
	private int diff = Integer.MAX_VALUE;
	int hrs1;
	int mins1;

	/**
	 * Leetcode verified
	 * 
	 * @param time
	 * @return
	 */
	public String nextClosestTime(String time) {

		Set<Integer> set = new HashSet<>();
		set.add(Integer.parseInt(time.substring(0, 1)));
		set.add(Integer.parseInt(time.substring(1, 2)));
		set.add(Integer.parseInt(time.substring(3, 4)));
		set.add(Integer.parseInt(time.substring(4, 5)));

		if (set.size() == 1)
			return time;

		givenTime = time;
		hrs1 = Integer.parseInt(givenTime.split(":")[0]);
		mins1 = Integer.parseInt(givenTime.split(":")[1]);

		List<Integer> digits = new ArrayList<>(set);
		dfs(digits, 0, digits.get(0), digits.get(0), digits.get(0), digits.get(0));
		return result;
	}

	private void dfs(List<Integer> digits, int i, int hr1, int hr2, int min1, int min2) {
		if (i == 4) {
			String time = hr1 + "" + hr2 + ":" + min1 + "" + min2;
			if (!time.equals(givenTime)) {
				int givenDiff = findDiff(time);
				if (givenDiff < diff) {
					result = time;
					diff = givenDiff;
				}
			}
			return;
		}
		for (int j = 0; j < digits.size(); j++) {
			if (i == 0 && isValidTime(digits.get(j), hr2, min1, min2))
				dfs(digits, i + 1, digits.get(j), hr2, min1, min2);
			if (i == 1 && isValidTime(hr1, digits.get(j), min1, min2))
				dfs(digits, i + 1, hr1, digits.get(j), min1, min2);
			if (i == 2 && isValidTime(hr1, hr2, digits.get(j), min2))
				dfs(digits, i + 1, hr1, hr2, digits.get(j), min2);
			if (i == 3 && isValidTime(hr1, hr2, min1, digits.get(j)))
				dfs(digits, i + 1, hr1, hr2, min1, digits.get(j));
		}
	}

	boolean isValidTime(int hr1, int hr2, int min1, int min2) {
		if ((hr1 >= 0 && hr1 <= 2) && ((hr1 < 2 && hr2 >= 0 && hr2 <= 9) || (hr1 == 2 && hr2 >= 0 && hr2 <= 4))
				&& (min1 >= 0 && min1 <= 5) && (min1 <= 5 && min2 >= 0 && min2 <= 9))
			return true;
		else
			return false;
	}

	int findDiff(String time2) {
		String[] time2tok = time2.split(":");
		int hrs2 = Integer.parseInt(time2tok[0]);
		int mins2 = Integer.parseInt(time2tok[1]);
		int diff = 0;
		if (hrs1 < hrs2 || (hrs1 == hrs2 && mins1 <= mins2)) {
			diff = (hrs2 - hrs1) * 60 + (mins2 - mins1);
		} else {
			diff = ((24 - hrs1) + hrs2) * 60 + (60 - mins1) + mins2;
		}
		return diff;
	}
}
