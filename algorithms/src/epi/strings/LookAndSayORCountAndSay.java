package epi.strings;

public class LookAndSayORCountAndSay {

	public static String lookAndSay(int i) {

		StringBuilder builder = new StringBuilder();
		builder.append("1");
		while (i > 1) {
			nextLookAndSay(builder);
			i--;
		}
		return builder.toString();
	}

	private static void nextLookAndSay(StringBuilder builder) {

		String input = builder.toString();
		builder.delete(0, builder.length());
		int i = 0;
		int counts = 0;
		while (i < input.length()) {
			char inte = input.charAt(i);
			counts++;
			if ((i + 1 < input.length() && inte != input.charAt(i + 1)) || (i == input.length() - 1)) {
				builder.append(counts);
				builder.append(inte);
				counts = 0;
			}
			i++;
		}

	}
}
