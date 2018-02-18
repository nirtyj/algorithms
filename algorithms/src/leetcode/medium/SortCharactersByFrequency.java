package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
public class SortCharactersByFrequency {

	static class IntegerChar {
		int frequency = 0;
		char character;

		IntegerChar(char c) {
			this.character = c;
		}
	}

	/**
	 * Leetcode verified
	 * 
	 * @param s
	 * @return
	 */
	public static String frequencySort(String s) {
		HashMap<Character, IntegerChar> map = new HashMap<>();
		PriorityQueue<IntegerChar> freqs = new PriorityQueue<>(new Comparator<IntegerChar>() {

			@Override
			public int compare(IntegerChar o1, IntegerChar o2) {
				return Integer.compare(o2.frequency, o1.frequency);
			}
		});

		for (int i = 0; i < s.length(); i++) {
			IntegerChar val = map.get(s.charAt(i));
			if (val == null) {
				val = new IntegerChar(s.charAt(i));
				map.put(s.charAt(i), val);
			}
			val.frequency++;
		}

		freqs.addAll(map.values());

		StringBuilder sb = new StringBuilder();
		while (!freqs.isEmpty()) {
			IntegerChar intcar = freqs.poll();
			for (int i = 1; i <= intcar.frequency; i++)
				sb.append(intcar.character);
		}
		return sb.toString();
	}

	/**
	 * O(n) solution
	 * 
	 * @param s
	 * @return
	 */

	public String frequencySortOn(String s) {
		if (s == null) {
			return null;
		}
		Map<Character, Integer> map = new HashMap();
		char[] charArray = s.toCharArray();
		int max = 0;
		for (Character c : charArray) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
			max = Math.max(max, map.get(c));
		}
		List<Character>[] array = buildArray(map, max);
		return buildString(array);
	}

	private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
		List<Character>[] array = new List[maxCount + 1];
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (array[count] == null) {
				array[count] = new ArrayList();
			}
			array[count].add(c);
		}
		return array;
	}

	private String buildString(List<Character>[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			List<Character> list = array[i];
			if (list != null) {
				for (Character c : list) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}
