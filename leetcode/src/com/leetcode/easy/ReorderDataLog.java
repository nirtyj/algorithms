package com.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class ReorderDataLog {

    /**
     * 8 ms.
     * @param logs
     * @return
     */
    public String[] reorderLogFilesBetter(String[] logs) {
        Comparator<String> compar = new Comparator<String>() {
            public int compare(String in, String au) {
                String[] thisTokens = in.split(" ", 2);
                String[] thatTokens = au.split(" ", 2);

                String thiskey = thisTokens[0];
                String thatkey = thatTokens[0];

                String thisvalue = thisTokens[1];
                String thatvalue = thatTokens[1];

                boolean thisisNumber = Character.isDigit(thisTokens[1].charAt(0));
                boolean thatisNumber = Character.isDigit(thatTokens[1].charAt(0));

                if (thisisNumber && thatisNumber) {
                    return 0;
                } else if (thisisNumber && !thatisNumber) {
                    return +1;
                } else if (!thisisNumber && thatisNumber) {
                    return -1;
                }
                int comp = thisvalue.compareTo(thatvalue);
                if (comp == 0) {
                    return thiskey.compareTo(thatkey);
                }
                return comp;
            }
        };
        Arrays.sort(logs, compar);
        return logs;
    }

    static class LogEntry implements Comparable<LogEntry> {
        String key;
        String value;
        boolean isNumber;
        int index;

        public LogEntry(String[] tokens, int index) {
            this.key = tokens[0];
            this.value = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
            this.index = index;
            try {
                Double.parseDouble(tokens[1]);
                this.isNumber = true;
            } catch (Exception e) {

            }
        }

        public int compareTo(LogEntry au) {
            if (this.isNumber && au.isNumber) {
                return Integer.compare(this.index, au.index);
            } else if (this.isNumber && !au.isNumber) {
                return +1;
            } else if (!this.isNumber && au.isNumber) {
                return -1;
            }
            int comp = this.value.compareTo(au.value);
            if (comp == 0) {
                return this.key.compareTo(au.key);
            }
            return comp;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        TreeSet<LogEntry> sorted = new TreeSet<>();
        for (int i = 0; i < logs.length; i++) {
            String[] tokens = logs[i].split("\\s+");
            LogEntry entry = new LogEntry(tokens, i);
            sorted.add(entry);
        }

        Iterator<LogEntry> i = sorted.iterator();
        String[] results = new String[logs.length];
        // Display elements
        int j = 0;
        while (i.hasNext()) {
            LogEntry entry = i.next();
            results[j++] = entry.key + " " + entry.value;
        }
        return results;
    }

}
