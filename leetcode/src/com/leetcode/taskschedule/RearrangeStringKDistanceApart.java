package com.leetcode.taskschedule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
s = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
*/
public class RearrangeStringKDistanceApart {

	public String rearrangeString(String s, int k) {
		HashMap<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int val = frequency.getOrDefault(s.charAt(i), 0) + 1;
			frequency.put(s.charAt(i), val);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
		maxHeap.addAll(frequency.entrySet());

		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		StringBuilder rearranged = new StringBuilder();
		while (!maxHeap.isEmpty()) {

			Map.Entry<Character, Integer> current = maxHeap.poll();
			rearranged.append(current.getKey());
			current.setValue(current.getValue() - 1);
			waitQueue.offer(current);

			if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
				continue;
			}
			// release from waitQueue if char is already k apart
			Map.Entry<Character, Integer> front = waitQueue.poll();
			// note that char with 0 count still needs to be placed in waitQueue as a place
			// holder
			if (front.getValue() > 0) {
				maxHeap.offer(front);
			}
		}

		return rearranged.length() == s.length() ? rearranged.toString() : "";
	}
}
