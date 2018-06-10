package com.leetcode.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leetcode.common.ListNode;

public class LeetcodeUtils {
	public static Set<String> arrayToSet(String[] dictArr) {
		Set<String> dict = new HashSet<>();
		for(String w: dictArr)
		{
			dict.add(w);
		}
		return dict;
	}
	
	public static List<String> arrayToList(String[] dictArr) {
		List<String> dict = new ArrayList<>();
		for(String w: dictArr)
		{
			dict.add(w);
		}
		return dict;
	}
	
	public static void printLinkedList(ListNode node) {
		while(node != null)
		{
			System.out.print(node.val + ", ");
			node = node.next;
		}
	}
}
