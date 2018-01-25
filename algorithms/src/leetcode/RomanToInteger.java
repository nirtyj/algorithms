package leetcode;

import java.util.HashMap;

/**
 * Leetcode verified
 * 
 * @author njaganathan
 *
 */
public class RomanToInteger {

	private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public static int romanToInt(String s) {
		int sum = 0;
		int prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			// to upper takes a lot of time
			Character c = Character.toUpperCase(s.charAt(i));
			int currVal = map.get(c);
			if (currVal < prev) {
				sum = sum - currVal;
			} else {
				prev = currVal;
				sum = sum + currVal;
			}

		}
		return sum;
	}
}
