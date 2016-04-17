package epi.strings;

public class FirstNonRepititiveChar {

	public static char findFirstNonRepititiveChar(String input) {

		int[] map = new int[256];

		for (int i = 0; i < 256; i++)
			map[i] = -1;

		for (int i = 0; i < input.length(); i++) {
			int val = map[input.charAt(i)];
			if (val >= 0) {
				map[input.charAt(i)] = -1;
			} else {
				map[input.charAt(i)] = i;
			}
		}

		int minindex = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			int pos = map[i];
			if (pos >= 0 && pos < minindex) {
				minindex = pos;
			}

		}

		if (minindex < input.length())
			return input.charAt(minindex);

		return input.charAt(0);
	}

}
