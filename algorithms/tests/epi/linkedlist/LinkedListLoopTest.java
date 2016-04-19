package epi.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListLoopTest {

	@Test
	public void testCyclicList1() {
		LinkedListNode l0 = new LinkedListNode(42, null);
		l0.next = l0;
		assertTrue(LinkedListLoop.findCycle(l0) == l0);
	}
	
	@Test
	public void testCyclicList2() {
		LinkedListNode l1 = new LinkedListNode(42, null);
	    LinkedListNode l2 = new LinkedListNode(42, null);
	    l1.next = l2;
	    l2.next = l1;
		assertTrue(LinkedListLoop.findCycle(l1) == l1);
		assertTrue(LinkedListLoop.findCycle(l2) == l2);
	}

	@Test
	public void testCyclicList3() {
		LinkedListNode l9 = new LinkedListNode(9, null);
		LinkedListNode l8 = new LinkedListNode(8, l9);
		LinkedListNode l7 = new LinkedListNode(7, l8);
		LinkedListNode l6 = new LinkedListNode(6, l7);
		LinkedListNode l5 = new LinkedListNode(5, l6);
		LinkedListNode l4 = new LinkedListNode(4, l5);		
		LinkedListNode l3 = new LinkedListNode(3, l4);
		LinkedListNode l2 = new LinkedListNode(2, l3);
		LinkedListNode l1 = new LinkedListNode(1, l2);
		// should output "l1 does not have cycle."
		assertTrue(LinkedListLoop.findCycle(l1) == null);
		System.out.println("l1 " + (LinkedListLoop.findCycle(l1) != null ? "has" : "does not have") + " cycle.");

		// make it a cycle
		l9.next = l4;
		// should output "l1 has cycle, located at node has value 2"
		assertTrue(LinkedListLoop.findCycle(l1) != null);
		assertTrue(LinkedListLoop.findCycle(l1).data == 4);
		LinkedListNode temp = LinkedListLoop.findCycle(l1);
		if (temp != null) {
			System.out.println("l1 has cycle, located at node has value " + temp.data);
		} else {
			System.out.println("l1 does not have cycle");
		}
	}

}
