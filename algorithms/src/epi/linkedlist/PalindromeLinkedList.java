package epi.linkedlist;

public class PalindromeLinkedList {

	public static boolean isLinkedListAPalindrome(LinkedListNode L) {
		
		LinkedListNode slow = L;
		LinkedListNode fast = L;

		LinkedListNode prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode endofHalf = prev;
		LinkedListNode reversedHead = ReverseLinkedList.reverseList(slow);

		LinkedListNode tempHead = reversedHead;
		boolean isPalindrome = true;
		while (tempHead != null) {
			if (L.data != tempHead.data) {
				isPalindrome = false;
				break;
			}
			L = L.next;
			tempHead = tempHead.next;
		}

		LinkedListNode reversedAgainHead = ReverseLinkedList.reverseList(reversedHead);
		endofHalf.next = reversedAgainHead;
		return isPalindrome;

	}
}
