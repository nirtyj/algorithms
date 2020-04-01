package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopkFrequentWords {

    /**
     * Leetcode verified
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0)
            return Collections.emptyList();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (a, b) -> {
            int comp = Integer.compare(a.getValue(), b.getValue());
            if (comp == 0) {
                return -a.getKey().compareTo(b.getKey());
            }
            return comp;
        });
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            int val = map.getOrDefault(word, 0);
            val++;
            map.put(word, val);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> rst = new ArrayList<>();
        while (queue.size() > 0)
            rst.add(0, queue.remove().getKey());
        return rst;
    }
}
