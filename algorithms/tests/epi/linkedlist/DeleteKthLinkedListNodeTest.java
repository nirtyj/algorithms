package epi.linkedlist;

import org.junit.Test;

public class DeleteKthLinkedListNodeTest {

	@Test
	public void testRemoveKthElement() {
		LinkedListNode L = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, null)));
		L = DeleteKthLFromastLinkedListNode.removeKthElemnt(L, 2);
		assert(L.data == 1 && L.next.data == 3);
		L = DeleteKthLFromastLinkedListNode.removeKthElemnt(L, 2);
		assert(L.data == 3 && L.next == null);
		L = DeleteKthLFromastLinkedListNode.removeKthElemnt(L, 1);
		assert(L == null);
	}
	

}
