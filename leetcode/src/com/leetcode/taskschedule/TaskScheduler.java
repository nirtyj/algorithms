package com.leetcode.taskschedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. 
Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*/
public class TaskScheduler {

	/**
	 * Leetcode verified
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval(char[] tasks, int n) {
		HashMap<Character, Integer> frequency = new HashMap<>();
		for (Character c : tasks) {
			int val = frequency.getOrDefault(c, 0) + 1;
			frequency.put(c, val);
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
				(a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
		queue.addAll(frequency.entrySet());

		int result = 0;
		while (!queue.isEmpty()) {
			int cooldown = n + 1; // increase 1 because you do not cool down when you remove the first one.
			List<Map.Entry<Character,Integer>> tempList = new ArrayList<>();
			while (cooldown > 0 && !queue.isEmpty()) {
				Map.Entry<Character, Integer> top = queue.poll();
				top.setValue(top.getValue() - 1);// decrease frequency, meaning it got executed
				tempList.add(top);// collect task to add back to queue
				result++;
				cooldown--;
			}

			for (Map.Entry<Character, Integer> entry : tempList) {
				if (entry.getValue() > 0) // add only if there are more than 0 tasks
					queue.offer(entry);
			}
			if (queue.isEmpty()) // all tasks are executed
				break;

			result = result + cooldown; // need to add cool down because, all tasks have been executed but cooldown is higher

		}
		return result;
	}
}
