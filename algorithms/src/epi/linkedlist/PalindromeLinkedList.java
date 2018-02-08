package epi.linkedlist;

import epi.linkedlist.node.ListNode;

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
	
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
}
