package epi.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeleteLinkedListNodeTest {

	@Test
	public void test() {
		LinkedListNode L =
		        new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		DeleteLinkedListNode.deletionFromList(L);
		assertTrue(L.data == 2 && L.next.data == 3);
	}

}
