package epi.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeleteDuplicateLinkedListNodesTest {


	private static void simpleTestRemoveDuplicates() {
		
		LinkedListNode L = null;
		LinkedListNode result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		assertTrue(result == null);
		L = new LinkedListNode(123, null);
		result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		assertTrue(result == L);
		L.next = new LinkedListNode(123, null);
		result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		assertTrue(result.next == null);

		// Creating an invalid input, 123 -> 124 -> 123, algo will not detect
		// dups!
		L.next = new LinkedListNode(124, null);
		L.next.next = new LinkedListNode(123, null);
		result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		assertTrue(result.data == 123);
		assertTrue(result.next.data == 124);
		assertTrue(result.next.next.data == 123);
	}

	@Test
	public void testRemoveDuplicates() {
		simpleTestRemoveDuplicates();
		LinkedListNode L;
		L = new LinkedListNode(2, new LinkedListNode(2, new LinkedListNode(2, new LinkedListNode(2, new LinkedListNode(2, null)))));
		LinkedListNode pre = null;
		LinkedListNode result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		int count = 0;
		while (result != null) {
			++count;
			if (pre != null) {
				assertTrue(!pre.data.equals(result.data));
			}
			pre = result;
			result = result.next;
		}
		assertTrue(count == 1);
		L = new LinkedListNode(2, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(4, null)))));
		result = DeleteDuplicateLinkedListNodes.removeDuplicates(L);
		assertEquals(2, result.data.intValue());
		assertEquals(3, result.next.data.intValue());
		assertEquals(4, result.next.next.data.intValue());
	}
	

}
