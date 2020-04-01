package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeDecodeTinyURL_535 {

    private static String encodings = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
    Random r = new Random();
    Map<String, String> urlDb = new HashMap<>();
    private int variableLengthBound = 10;

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
