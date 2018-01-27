package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeTinyURL {

	private static String encodings = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
	private int variableLengthBound = 10;
	Random r = new Random();
	Map<String, String> urlDb = new HashMap<>();

	private String getKey() {
		int length = r.nextInt(variableLengthBound - 1) + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = r.nextInt(70);
			sb.append(encodings.charAt(index));
		}
		return sb.toString();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String key = getKey();
		while (urlDb.containsKey(key)) {
			key = getKey();
		}
		urlDb.put(key, longUrl);
		return key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return urlDb.get(shortUrl);
	}
}
