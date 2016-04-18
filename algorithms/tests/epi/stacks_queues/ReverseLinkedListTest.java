package epi.stacks_queues;

import static org.junit.Assert.*;

import org.junit.Test;

import epi.linkedlist.LinkedListNode;

public class ReverseLinkedListTest {

	@Test
	public void test() {
		LinkedListNode root = new LinkedListNode("alice");
		LinkedListNode middle = new LinkedListNode("likes");
		LinkedListNode end = new LinkedListNode("bob");
		
		root.next = middle;
		middle.next = end;
		
		root = ReverseLinkedList.reverseLinkedList(root);
		
		assertEquals("bob", root.value);
		assertEquals("likes", root.next.value);
		assertEquals("alice", root.next.next.value);
		
	}

}
