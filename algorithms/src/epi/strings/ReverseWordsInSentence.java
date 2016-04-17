package epi.strings;

import java.util.Stack;

import epi.linkedlist.LinkedListNode;
import epi.linkedlist.ReverseLinkedList;

public class ReverseWordsInSentence {

	public static void reverseWords(char[] words) {
		reverseCharArray(words, 0, words.length - 1);

		int i = 0, j = 0;
		while (j < words.length) {
			if (words[j] == ' ') {
				reverseCharArray(words, i, j - 1);
				while (words[j] == ' ')
					j++;
				i = j;
			} else {
				j++;
			}
		}

		// if (j == words.length) {
		reverseCharArray(words, i, j - 1);
	}

	public static void reverseCharArray(char[] input, int i, int j) {
		while (i <= j) {
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;

			i++;
			j--;
		}

	}

	public static String reverseWordsWithLinkedList(String words) {

		int i = 0;
		int j = 0;
		LinkedListNode head = new LinkedListNode();
		LinkedListNode curr = head;
		while (j < words.length()) {
			if (words.charAt(j) == ' ') {
				curr.next = new LinkedListNode(words.substring(i, j));
				curr = curr.next;
				i = j;

				while (words.charAt(j) == ' ')
					j++;

				curr.next = new LinkedListNode(words.substring(i, j));
				curr = curr.next;
				i = j;
			} else {
				j++;
			}
		}

		// 	if (j == words.length()) {
		curr.next = new LinkedListNode(words.substring(i, j));
		curr = curr.next;

		LinkedListNode newHead = ReverseLinkedList.reverseList(head.next);

		StringBuilder builder = new StringBuilder();
		while (newHead != null) {
			builder.append(newHead.value);
			newHead = newHead.next;
		}
		String val = builder.toString();
		return val;
	}

	public static String reverseWordsWithStack(String words) {

		int i = 0;
		int j = 0;
		Stack<String> stack = new Stack<String>();
		while (j < words.length()) {
			if (words.charAt(j) == ' ') {
				stack.push(words.substring(i, j));
				i = j;

				while (words.charAt(j) == ' ')
					j++;

				stack.push(words.substring(i, j));
				i = j;
			} else {
				j++;
			}
		}

		// 	if (j == words.length()) {
		stack.push(words.substring(i, j));

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}

}
