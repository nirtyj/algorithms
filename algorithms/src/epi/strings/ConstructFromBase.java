package epi.strings;

public class ConstructFromBase {

	public static String convertBase(String input, int bfrom, int bto) {
		boolean isNegative = input.startsWith("-");
		if (isNegative)
			input = input.substring(1);
		StringBuilder builder = new StringBuilder();

		int base10Val = convertToBase10(input, bfrom);

		convertToBase(builder, base10Val, bto);

		if (isNegative)
			builder.append("-");
		return builder.reverse().toString();
	}

	private static void convertToBase(StringBuilder builder, int base10Val, int bto) {

		do {
			int index = base10Val % bto;
			if (index >= 10) {
				char val = Character.valueOf((char) (Character.valueOf('A') + index - 10));
				builder.append(val);
			} else {
				builder.append(index);
			}
			base10Val = base10Val / bto;
		} while (base10Val != 0);
	}

	private static int convertToBase10(String input, int bfrom) {
		int i = input.length() - 1;
		int result = 0;
		int exp = 0;
		while (i >= 0) {
			int val = Character.isDigit(input.charAt(i)) ? input.charAt(i) - '0' : input.charAt(i) - 'A' + 10;
			int pow = (int) (Math.pow(bfrom, exp));
			result = result + val * pow;
			exp++;
			i--;
		}
		return result;
	}
}
