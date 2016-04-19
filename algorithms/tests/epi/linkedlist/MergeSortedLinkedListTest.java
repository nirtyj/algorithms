package epi.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MergeSortedLinkedListTest {

	@Test
	public void test() {
		LinkedListNode L1 = LinkedListTestUtils.getList();
		int l1Size = L1.size();		
		LinkedListNode L2 = LinkedListTestUtils.getList();
		int l2Size = L2.size();
		System.out.println(" L1 : " + L1.toString());
		System.out.println(" L2 : " + L2.toString());
		LinkedListNode sortedHead = MergeSortedLinkedList.mergeTwoSortedLists(L1, L2);
		System.out.println(" Merged : " + sortedHead.toString());

		int count = 0;
		int pre = Integer.MIN_VALUE;
		LinkedListNode tempNext = sortedHead;
		while (tempNext != null) {
			count++;
			assertTrue(pre <= tempNext.data);
			pre = tempNext.data;
			tempNext = tempNext.next;
		}

		// Make sure the merged list have the same number of nodes as L1 and L2.
		assertEquals(l1Size + l2Size, count);
	}

}
