package com.leetcode.linkedlist;

import org.junit.Test;

import com.leetcode.common.ListNode;

public class ReverseNodesInKGroupTest {

	@Test
	public void test() {
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode begin = new ListNode(1);
		begin.next = new ListNode(2);
		begin.next.next = new ListNode(3);
		begin.next.next.next = new ListNode(4);
		begin.next.next.next.next = new ListNode(5);
		r.reverseKGroup(begin, 3);
	}

	

}
