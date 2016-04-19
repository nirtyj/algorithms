package epi.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseLinkedListTest {

	@Test
	public void testReverseRecursive()
	{
		LinkedListNode L1 = LinkedListTestUtils.getList();
		LinkedListNode copyL1 = LinkedListClone.cloneList(L1);
		assertEquals(L1.toString(), copyL1.toString());		
		System.out.println(" L1 :" + L1.toString());
		LinkedListNode reversedHead = ReverseLinkedList.reverseListRecursive(L1);
		System.out.println(" reverse :" + reversedHead.toString());
		LinkedListNode doubleReverse = ReverseLinkedList.reverseListRecursive(reversedHead);
		System.out.println(" double reverse :" + doubleReverse.toString());
		
		assertEquals(copyL1.toString(), doubleReverse.toString());
	}
	
	@Test
	public void testReverseIterative()
	{
		LinkedListNode L1 = LinkedListTestUtils.getList();
		LinkedListNode copyL1 = LinkedListClone.cloneList(L1);
		assertEquals(L1.toString(), copyL1.toString());		
		System.out.println(" L1 :" + L1.toString());
		LinkedListNode reversedHead = ReverseLinkedList.reverseListIterative(L1);
		System.out.println(" reverse :" + reversedHead.toString());
		LinkedListNode doubleReverse = ReverseLinkedList.reverseListIterative(reversedHead);
		System.out.println(" double reverse :" + doubleReverse.toString());
		assertEquals(copyL1.toString(), doubleReverse.toString());
	}
	

}
