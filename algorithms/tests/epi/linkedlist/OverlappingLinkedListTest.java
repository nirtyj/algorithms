package epi.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OverlappingLinkedListTest {

	@Test
	public void testOverlappingNoCycle() {
		
		LinkedListNode L1 = null;
		LinkedListNode L2 = null;
		// L1: 1->2->3->null
		L1 = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		L2 = L1.next.next;
		assertEquals(new Integer(3), OverlappingLinkedList.overlappingNoCycleLists(L1, L2).data);
		// L2: 4->5->null
		L2 = new LinkedListNode(4, new LinkedListNode(5, null));
		assertTrue(OverlappingLinkedList.overlappingNoCycleLists(L1, L2) == null);
	}
	
	private static void smallTest() {
		
		LinkedListNode l1 = null;
		LinkedListNode l2 = null;
		// L1: 1->2->3->4->5->6-
		// ^ ^ |
		// | |____|
		// L2: 7->8-----
		l1 = new LinkedListNode(1,
				new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6, null))))));
		l1.next.next.next.next.next.next = l1.next.next.next.next;

		l2 = new LinkedListNode(7, new LinkedListNode(8, null));
		l2.next.next = l1.next.next.next;
		assertTrue(OverlappingLinkedList.overlappingLists(l1, l2).data == 4);

		// L1: 1->2->3->4->5->6-
		// ^ ^ |
		// | |____|
		// L2: 7->8---
		l2.next.next = l1.next.next;
		assertTrue(OverlappingLinkedList.overlappingLists(l1, l2).data == 3);
	}

	@Test
	public void testOverlappingList() {
		smallTest();
		LinkedListNode L1, L2;
		// L1: 1->2->3->null
		L1 = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		L2 = L1.next.next;
		assertTrue(OverlappingLinkedList.overlappingLists(L1, L2).data == 3);
		// L2: 4->5->null
		L2 = new LinkedListNode(4, new LinkedListNode(5, null));
		assertTrue(OverlappingLinkedList.overlappingLists(L1, L2) == null);
		L1.next.next.next = L1;
		assertTrue(OverlappingLinkedList.overlappingLists(L1, L2) == null);
		L2.next.next = L2;
		assertTrue(OverlappingLinkedList.overlappingLists(L1, L2) == null);
		L2.next.next = L1;
		assertTrue(OverlappingLinkedList.overlappingLists(L1, L2) != null);
	}
	

}
