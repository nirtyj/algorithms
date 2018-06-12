package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.leetcode.common.Interval;

/**
363. https://leetcode.com/problems/partition-labels/description/
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/
public class PartitionLabels_363 {

	/**
	 * Leetcode verified
	 * @param S
	 * @return
	 */
	public List<Integer> partitionLabels(String S) {
		LinkedHashMap<Character, Interval> intervals = new LinkedHashMap<Character, Interval>();
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			Interval inter = intervals.getOrDefault(c, new Interval(i, i));
			if (i <= inter.start)
				inter.start = i;
			if (i >= inter.end)
				inter.end = i;
			intervals.put(c, inter);
		}

		List<Integer> result = new ArrayList<>();
		Interval pre = null;
		for (Interval inter : intervals.values()) {
			if (pre == null) {
				pre = inter;
				continue;
			}
			if (inter.start <= pre.end) {
				pre.start = Math.min(pre.start, inter.start);
				pre.end = Math.max(pre.end, inter.end);
			} else {
				result.add(pre.end - pre.start + 1);
				pre = inter;
			}
		}
		if (pre != null)
			result.add(pre.end - pre.start + 1);

		return result;
	}
	
	/**
	 * Greedy solution
	 */
	public List<Integer> partitionLabels1(String S) {
        // character's last index
        Map<Character, Integer> hmp = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
                hmp.put(S.charAt(i), i);
        }
        
        //second pass to make divisions
        List<Integer> lst = new ArrayList<>();
        int lastInd = 0;
        int firstInd = 0;
        for(int i = 0; i < S.length(); i++) {
            lastInd = Math.max(lastInd, hmp.get(S.charAt(i)));
            if(i == lastInd) {
                lst.add(lastInd - firstInd + 1);
                firstInd = lastInd + 1;
            }
        }
        return lst;
    }
}
