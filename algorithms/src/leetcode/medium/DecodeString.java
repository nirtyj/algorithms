package leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string. The encoding rule is:
 * k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive
 * integer. You may assume that the input string is always valid; No extra white
 * spaces, square brackets are well-formed, etc. Furthermore, you may assume
 * that the original data does not contain any digits and that digits are only
 * for those repeat numbers, k. For example, there won't be input like 3a or
 * 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

	/**
	 * Leetcode verified
	 * 
	 * @param s
	 * @return
	 */
	public static String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ']') {
				LinkedList<String> ll = new LinkedList<String>();
				while (!stack.empty() && !stack.peek().equals("[")) {
					ll.addFirst(stack.pop());
				}
				// discard the [
				stack.pop();

				StringBuilder tempInt = new StringBuilder();
				while (!stack.isEmpty() && (stack.peek().charAt(0) >= 48 && stack.peek().charAt(0) <= 57)) {
					tempInt.append(stack.pop());
				}

				tempInt.reverse();

				int times = Integer.parseInt(tempInt.toString());
				StringBuilder tempWord = new StringBuilder();
				for (String st : ll) {
					tempWord.append(st);
				}
				StringBuilder word = new StringBuilder();
				for (int m = 1; m <= times; m++) {
					word.append(tempWord);
				}
				stack.push(word.toString());
			} else {
				// regular chars, ints, and [
				stack.push(Character.toString(c));
			}
		}
		for (String str : stack) {
			sb.append(str);
		}
		return sb.toString();
	}
}
