package epi.linkedlist;

import java.util.Random;

public class LinkedListTestUtils {

	public static LinkedListNode getList()
	{
		LinkedListNode L1 = null;
		int n;
		Random rnd = new Random();
		n = rnd.nextInt(30);
		if (n == 0) {
			n = 10;
		}
		
		int randomdiff1 = rnd.nextInt(5);

		if (randomdiff1 == 0) {
			randomdiff1 = 1;
		}
		
		for (int i = n; i > 0; i = i - randomdiff1) {
			LinkedListNode temp = new LinkedListNode(i, null);
			temp.next = L1;
			L1 = temp;
		}
		return L1;
	}
}
