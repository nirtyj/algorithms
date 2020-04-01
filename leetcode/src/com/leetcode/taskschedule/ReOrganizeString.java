package com.leetcode.taskschedule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReOrganizeString {

    public String reorganizeString(String s) {
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
        int k = 2; // it has to be 2 spaces apart
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
