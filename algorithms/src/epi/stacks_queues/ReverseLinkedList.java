package epi.stacks_queues;

import java.util.Stack;

import epi.linkedlist.LinkedListNode;

public class ReverseLinkedList {

	public static LinkedListNode reverseLinkedList(LinkedListNode root)
	{
		Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
		
		while(root != null)
		{
			stack.push(root);
			root = root.next;
		}
		
		LinkedListNode head = stack.pop();
		LinkedListNode prev = head;
		while(!stack.isEmpty())
		{
			LinkedListNode node = stack.pop();
			node.next = null;
			prev.next = node;
			prev = node;				
		}
		return head;
	}
}
