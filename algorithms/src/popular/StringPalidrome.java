package popular;

public class StringPalidrome {

	// I Prefer Pi
	public static boolean isPalindrome(String phrase) {

		int i = 0;
		int j = phrase.length() - 1;

		while (i <= j) {
			while (i <= j && phrase.charAt(i) == ' ')
				i++;

			while (i <= j && phrase.charAt(j) == ' ')
				j--;

			if (i <= j && Character.toLowerCase(phrase.charAt(i)) != Character.toLowerCase(phrase.charAt(j)))
				return false;

			i++;
			j--;

		}

		return true;
	}
}
