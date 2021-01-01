package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 *
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
 *
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
public class AnalyzeUserWebsiteVisitPattern_LC1152 {
    static class TimeVisit implements Comparable<TimeVisit> {
        Integer time;
        String website;
        TimeVisit(int time, String website) {
            this.time = time;
            this.website = website;
        }

        @Override
        public int compareTo(TimeVisit other){
            return Integer.compare(time, other.time);
        }
    }


    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<TimeVisit>> pageVisits = new HashMap<>();
        for(int i=0;i<timestamp.length;i++){
            List<TimeVisit> pages = pageVisits.getOrDefault(username[i], new ArrayList<>());
            pages.add(new TimeVisit(timestamp[i], website[i]));
            pageVisits.put(username[i], pages);
        }
        HashMap<String, Integer> frequency = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(); // can be optimized
        int max = 0;
        for(List<TimeVisit> pages : pageVisits.values()){
            Set<String> set = new HashSet<>();
            Collections.sort(pages);
            for(int i=0;i<pages.size();i++){
                for (int j = i + 1; j < pages.size(); j++) {
                    for (int k = j + 1; k < pages.size(); k++) {
                        String key = pages.get(i).website + "_" + pages.get(j).website + "_" + pages.get(k).website;
                        if (!set.contains(key)) {
                            int count = frequency.getOrDefault(key, 0);
                            count++;
                            frequency.put(key, count);
                            if (count == max) {
                                queue.offer(key);
                            } else if (count > max){
                                queue.clear();
                                queue.offer(key);
                                max = count;
                            }
                            set.add(key);
                        }
                    }
                }
            }
        }
        String top = queue.poll();
        String[] tokens = top.split("_");
        return Arrays.asList(tokens);
    }
}
