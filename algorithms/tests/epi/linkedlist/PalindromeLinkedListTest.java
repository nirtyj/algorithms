package epi.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeLinkedListTest {

	@Test
	public void testPalindromic() {

		LinkedListNode head = null;

		// A link list is a palindrome.
		for (int i = 6; i >= 1; --i) {
			LinkedListNode curr = new LinkedListNode(1, head);
			head = curr;
		}
		assertTrue(PalindromeLinkedList.isLinkedListAPalindrome(head));

		// Still a palindrome linked list.
		head = null;
		for (int i = 5; i >= 1; --i) {
			LinkedListNode curr = new LinkedListNode(1, head);
			head = curr;
		}
		head.next.next.data = 3;
		assertTrue(PalindromeLinkedList.isLinkedListAPalindrome(head));
		// Not a palindrome linked list.
		head = null;
		for (int i = 5; i >= 1; --i) {
			LinkedListNode curr = new LinkedListNode(i, head);
			head = curr;
		}
		assertTrue(!PalindromeLinkedList.isLinkedListAPalindrome(head));
	}
}
