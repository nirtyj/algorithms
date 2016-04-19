package epi.linkedlist;

public class OverlappingLinkedList {

	public static LinkedListNode overlappingNoCycleLists(LinkedListNode L1, LinkedListNode L2) {

		int l1Size = L1.size();
		int l2Size = L2.size();
		int diff = Math.abs(l1Size - l2Size);
		LinkedListNode largeList = L1;
		LinkedListNode smallList = L2;

		if (l2Size > l1Size) {
			largeList = L2;
			smallList = L1;
		}

		while (diff != 0) {
			largeList = largeList.next;
			diff--;
		}

		while (smallList != null && largeList != null && smallList!=largeList) {
			smallList = smallList.next;
			largeList = largeList.next;
		}
		
		return smallList;
	}

	public static LinkedListNode overlappingLists(LinkedListNode L1, LinkedListNode L2) {
		
		LinkedListNode l1Cycle = LinkedListLoop.findCycle(L1);
		LinkedListNode l2Cycle = LinkedListLoop.findCycle(L2);
		
		if(l1Cycle == null && l2Cycle == null)
			return overlappingNoCycleLists(L1, L2);
		else if((l1Cycle == null && l2Cycle!=null) || (l1Cycle !=null && l2Cycle == null))
			return null;
		
		// Both lists have cycles.
		LinkedListNode temp = l2Cycle;
		while (temp != l1Cycle && temp != l2Cycle) {
			temp = temp.next;
		}

		// L1 and L2 do not end in the same cycle.
		if (temp != l1Cycle) {
			return null; // Cycles are disjoint.
		}
				
		int l1Dist = distance(L1, l1Cycle);
		int l2Dist = distance(L2, l2Cycle);
		
		int diff = Math.abs(l1Dist - l2Dist);
		LinkedListNode l1 = L1;
		LinkedListNode l2 = L2;

		if (l2Dist > l1Dist) {
			while (diff != 0) {
				l2 = l2.next;
				diff--;
			}
		}
		else
		{
			while (diff != 0) {
				l1 = l1.next;
				diff--;
			}
		}

		while (l2 != l2Cycle && l1 != l1Cycle && l2!=l1) {
			l2 = l2.next;
			l1 = l1.next;
		}
		
		if(l2 == l1)
			return l2;
		else 
			return l1Cycle;
	}
	
	static int distance (LinkedListNode n1, LinkedListNode n2)
	{
		int count = 0;
		while(n1!=null && n1!=n2)
		{
			count++;
			n1 = n1.next;
		}
		return count;
	}
}
