package epi.strings;

public class IntegerStringConversions {

	public static String convertIntegerToString(Integer input) {
		boolean isNegative = input < 0;
		StringBuilder builder = new StringBuilder();
		input = Math.abs(input);

		do {
			int index = input % 10;
			builder.append(index);
			input = input / 10;
		} while (input != 0);

		if (isNegative)
			builder.append("-");
		return builder.reverse().toString();
	}

	public static int convertStringToInteger(String input) {
		boolean isNegative = input.startsWith("-");
		if (isNegative)
			input = input.substring(1);
		int i = 0;
		int result = 0;
		while (i < input.length()) {
			int val = input.charAt(i) - '0';
			result = result * 10 + val;
			i++;
		}

		if (isNegative)
			result = -result;
		return result;
	}
}
