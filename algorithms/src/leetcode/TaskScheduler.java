package leetcode;

import java.util.Arrays;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

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
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        // the task with biggest number of task goes to the right
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0; // cooling time counter
            while (i <= n) { // until you get heated, pick up from the right to left.
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            // everytime you breakout for a new cooldown, re-order the array
            Arrays.sort(map);
        }
        return time;
    }
}
