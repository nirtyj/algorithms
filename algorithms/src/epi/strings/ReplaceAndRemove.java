package epi.strings;

public class ReplaceAndRemove {

	/**
	 * a -> d, d
	 * b - delete
	 * @param size
	 * @param input
	 */
	public static void replaceAndRemove(int size, char[] input) {
		int aCount = 0;
		int writeIndex = 0;
		for (int i = 0; i < size; i++) {
			if (input[i] != 'b')
				input[writeIndex++] = input[i];

			if (input[i] == 'a')
				aCount++;

		}

		int j = writeIndex - 1;
		writeIndex = writeIndex + aCount - 1;
		while (j >= 0) {
			char val = input[j];
			if (val == 'a') {
				input[writeIndex--] = 'd';
				input[writeIndex--] = 'd';
			} else {
				input[writeIndex--] = val;
			}
			j--;
		}
	}

}
