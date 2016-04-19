package epi.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReverseSubLinkedListTest {
	private void simpleTestSublist() {
		
		LinkedListNode L = null;
		LinkedListNode result = ReverseSubLinkedList.reverseSublist(L, 0, 0);
		assertTrue(result == null);

		L = new LinkedListNode(1, null);
		result = ReverseSubLinkedList.reverseSublist(L, 0, 0);
		assertTrue(result == L);

		L = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		result = ReverseSubLinkedList.reverseSublist(L, 0, 1);
		assertTrue(result.data == 2 && result.next.data == 1 && result.next.next.data == 3);

		L = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		result = ReverseSubLinkedList.reverseSublist(L, 0, 2);
		assertTrue(result.data == 3 && result.next.data == 2 && result.next.next.data == 1);
	}

	@Test
	public void testReverseSublist()
	{
		simpleTestSublist();
		
	    LinkedListNode L;
	    L = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
	    LinkedListNode result = ReverseSubLinkedList.reverseSublist(L, 3, 3);
	    assertTrue(result.data.equals(1) && result.next.data.equals(2) &&
	           result.next.next.data.equals(3) && result.next.next.next == null);
	    while (result != null) {
	      System.out.println(result.data);
	      result = result.next;
	    }

	    result = ReverseSubLinkedList.reverseSublist(L, 1, 2);
	    assertTrue(result.data.equals(1) && result.next.data.equals(3) &&
	           result.next.next.data.equals(2) && result.next.next.next == null);
	    while (result != null) {
	      System.out.println(result.data);
	      result = result.next;
	    }
	}

}
