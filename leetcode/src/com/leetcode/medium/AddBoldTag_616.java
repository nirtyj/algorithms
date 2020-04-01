package com.leetcode.medium;

import com.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 616. https://leetcode.com/problems/add-bold-tag-in-string/description/
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1:
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 */
public class AddBoldTag_616 {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if (intervals == null || intervals.size() == 0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>() {
            // sort the start if they are different
            // if start is same, sort based on the end
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > pre.end + 1) {
                result.add(pre);
                pre = curr;
            } else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }

    /**
     * Leetcode verified - faster for small s
     *
     * @param s
     * @param dict
     * @return
     */
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j])
                j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }

    /**
     * Leetcode verified - slower for small s
     *
     * @param s
     * @param dict
     * @return
     */
    public String addBoldTagSlower(String s, String[] dict) {
        List<Interval> result = new ArrayList<Interval>();
        for (String keyword : dict) {
            String searchableString = s;
            int index = searchableString.indexOf(keyword);
            while (index >= 0) {
                result.add(new Interval(index, index + keyword.length() - 1));
                index = searchableString.indexOf(keyword, index + 1);
            }
        }
        List<Interval> merged = merge(result);
        HashSet<Integer> starts = new HashSet<>();
        HashSet<Integer> ends = new HashSet<>();
        for (Interval st : merged) {
            starts.add(st.start);
            ends.add(st.end);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (starts.contains(i)) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (ends.contains(i)) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
